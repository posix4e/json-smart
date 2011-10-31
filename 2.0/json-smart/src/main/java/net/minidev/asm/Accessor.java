package net.minidev.asm;

/*
 *    Copyright 2011 JSON-SMART authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

import net.minidev.json.JSONUtil;
import net.minidev.json.annotate.JsonIgnore;

/**
 * Contains all information needed to access a java field.
 * 
 * field, getter setter
 * 
 * this object is used internally by BeansAcces
 * 
 * @see BeansAccess
 * 
 * @author uriel Chemouni
 */
public class Accessor {
	protected Field field;
	protected Method setter;
	protected Method getter;
	protected int index;
	protected Class<?> type;
	protected Type genericType;

	public int getIndex() {
		return index;
	}

	public boolean isPublic() {
		return setter == null;
	}

	public String getName() {
		return field.getName();
	}

	public Class<?> getType() {
		return type;
	}

	public Type getGenericType() {
		return genericType;
	}

	public Accessor(Class<?> c, Field field) {
		int m = field.getModifiers();
		JsonIgnore ignore = field.getAnnotation(JsonIgnore.class);
		if (ignore != null)
			if (ignore.value())
				return;
			else
				m &= ~(Modifier.TRANSIENT);
		if ((m & (Modifier.STATIC | Modifier.TRANSIENT)) > 0)
			return;
		if ((m & Modifier.PUBLIC) > 0) {
			this.field = field;
		} else {
			String name = JSONUtil.getSetterName(field.getName());
			try {
				setter = c.getDeclaredMethod(name, field.getType());
			} catch (Exception e) {
				return;
			}
			boolean isBool = field.getType().equals(Boolean.TYPE);
			if (isBool) {
				name = JSONUtil.getIsName(field.getName());
			} else {
				name = JSONUtil.getGetterName(field.getName());
			}
			try {
				getter = c.getDeclaredMethod(name);
			} catch (Exception e) {
			}
			if (getter == null && isBool) {
				try {
					getter = c.getDeclaredMethod(JSONUtil.getGetterName(field.getName()));
				} catch (Exception e) {
					return;
				}
			}
			if (getter == null)
				return;
			this.field = field;
		}
		this.type = field.getType();
		this.genericType = field.getGenericType();
	}
}
