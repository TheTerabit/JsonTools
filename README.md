# JsonTools

## Java / Spring / REST API
---

## POST request at:
### http://json-tools.herokuapp.com/api/process

  ### Body
  Any JSON document to process.

  ### Parameters
  | Name | Type | Description |
  | --- | --- | --- |
  | `whiteSpaces` | string | Can be one of `add` (makes JSON looks pretty) or `delete` (minifies JSON to one line). Default: `add` |
  | `removeNulls` | boolean | When `true` returns JSON without all empty fields e.g. "", [], null. Default: `false` |
  | `attributesMode` | string | Can be one of `pick` (returns fields specified in `attributes` parameter) or `delete` (returns fields not specified in `attributes` parameter). Default: `delete` |
  | `attributes` | string | Comma-separated list of fields to be picked or deleted depending on `attributesMode` value. Default: `null` |

---

## POST request at:
### http://json-tools.herokuapp.com/api/compare

  ### Body
  String containing two JSONs seperated by `###`. Endpoint returns a list of line numbers with differences.

---



## Collaborators:

<a href="https://github.com/BartekPrz"><img src="https://avatars3.githubusercontent.com/u/38264818?s=400&v=4" title="BartekPrz" width="80" height="80"></a>
<a href="https://github.com/Pefes"><img src="https://avatars2.githubusercontent.com/u/56848101?s=400&v=4" title="Pefes" width="80" height="80"></a>
<a href="https://github.com/NaIwo"><img src="https://avatars3.githubusercontent.com/u/38052250?s=400&v=4" title="NaIwo" width="80" height="80"></a>
<a href="https://github.com/TheTerabit"><img src="https://avatars1.githubusercontent.com/u/36801835?s=400&u=8483c9b9d1d31289f80d06604a22e905b448cf5c&v=4" title="TheTerabit" width="80" height="80"></a>


## Tasks:
### https://trello.com/b/DRANpbdY/io

## Definition of Done:
### https://docs.google.com/spreadsheets/d/e/2PACX-1vRh3VmprccDy5JC2hxggI1UmWwos2_ukytrvbvvzRT2BkgwskpF3wNIYTx4WXUhAopLKknACRZ65kWt/pubhtml#

## UML:
![UML](https://github.com/TheTerabit/JsonTools/blob/dev/UML.png)

