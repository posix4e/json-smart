# Json BecnhMark #

## Bench Protole ##

Those test are generate by parrsing 50.000 pre-build json string.

to minimise gc effect on bench, a new VM is lanched for each test.


## New Tests ##

The bench run on an intel P9700 CPU, using sun JVM 1.6.22 64bit + SSD
each bench had been lunch 10 times, the best time had been keeped.

## BenchMark run directly after the JVM start ##
**update on 30 May**
  * JsonIJ version is now 0.2.7
  * Json-smart is now 1.0.6.3
  * argo is now 2.8

## BenchMark : bench ##
Result display as **% of the fastest API**.
Lower is better, for example 400% means that JSon-smart is 4 times faster.


| Test |  **Sojo** | **Argo** | **json-lib** | **JsonMe** | **org.json** | **json-Simple** | **Jackson** | **StringTree** | **JsonIJ** | **Json-fast** | **Json-Smart** |
|:-----|:----------|:---------|:-------------|:-----------|:-------------|:----------------|:------------|:---------------|:-----------|:--------------|:---------------|
| **mixte** |1 129 %    |822 %     |834 %         |395 %       |437 %         |324 %            |269 %        |287 %           |205 %       |134 %          |100 %           |
| **text** |1 628 %    |965 %     |879 %         |363 %       |610 %         |434 %            |419 %        |369 %           |271 %       |174 %          |100 %           |
| **int** |1 300 %    |966 %     |718 %         |359 %       |521 %         |281 %            |286 %        |293 %           |224 %       |118 %          |100 %           |
| **unicode** |1 177 %    |674 %     |549 %         |218 %       |445 %         |351 %            |315 %        |216 %           |256 %       |147 %          |100 %           |
| **boolean** |1 285 %    |724 %     |809 %         |391 %       |498 %         |332 %            |291 %        |210 %           |228 %       |138 %          |100 %           |
| **float** |1 145 %    |794 %     |711 %         |1 152 %     |450 %         |243 %            |265 %        |272 %           |201 %       |126 %          |100 %           |
| **TOTAL** |1 251 %    |818 %     |739 %         |511 %       |484 %         |319 %            |300 %        |272 %           |228 %       |137 %          |100 %           |


## BenchMark with preload classes ##
**Not updated yet**

preloading class look to have no significant effect, due to SSD usage.

| Test |  **JsonIJ** | **Sojo** | **Argo** | **json-lib** | **org.json** | **JsonMe** | **json-Simple** | **Jackson** | **StringTree** | **Json-fast** | **Json-Smart** |
|:-----|:------------|:---------|:---------|:-------------|:-------------|:-----------|:----------------|:------------|:---------------|:--------------|:---------------|
| **mixte** |1 302 %      |1 150 %   |804 %     |858 %         |452 %         |365 %       |323 %            |258 %        |275 %           |133 %          |100 %           |
| **text** |1 772 %      |1 492 %   |914 %     |782 %         |582 %         |332 %       |409 %            |355 %        |332 %           |159 %          |100 %           |
| **int** |1 266 %      |1 345 %   |907 %     |723 %         |447 %         |290 %       |279 %            |250 %        |304 %           |118 %          |100 %           |
| **unicode** |N/A          |1 185 %   |674 %     |538 %         |448 %         |216 %       |358 %            |280 %        |216 %           |135 %          |100 %           |
| **boolean** |1 401 %      |1 168 %   |680 %     |717 %         |459 %         |283 %       |300 %            |254 %        |192 %           |129 %          |100 %           |
| **float** |1 024 %      |1 129 %   |740 %     |707 %         |384 %         |1 043 %     |247 %            |242 %        |280 %           |125 %          |100 %           |
| **TOTAL** |N/A          |1 230 %   |781 %     |717 %         |454 %         |452 %       |314 %            |269 %        |266 %           |132 %          |100 %           |