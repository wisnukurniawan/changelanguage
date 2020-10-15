### Localization Playground
Simple project to get playground localization programmatically

NOTE: The implementation align with **androidx.appcompat:appcompat:1.2.0**

1. Test case provide string ressources for different country
    - values/strings/bahasa		: English
    - values-id/strings/bahasa	: Indonesia
    - values-th/strings/bahasa	: Thailand

2. Then test Localization Utils by hardcoded language

```kotlin
// Passing LANGUAGE with id or th
LocalizationUtil.applyLanguageContext(newBase, LANGUAGE)
```

3. Make sure the view display correct value
```kotlin
tv_language1.text = getString(R.string.bahasa)
tv_language2.text = applicationContext.getString(R.string.bahasa)
tv_language3.text = resources.getString(R.string.bahasa)
```
### Test result
Language: *id*
| android version   | context   | applicationContext  | status |
|-------------------|-----------|---------------------|--------|
| 19 				| Indonesia | Indonesia           | PASSED |
| 21 				| Indonesia | Indonesia           | PASSED |
| 23 				| Indonesia | Indonesia           | PASSED |
| 26 				| Indonesia | Indonesia           | PASSED |
| 27 				| Indonesia | Indonesia           | PASSED |
| 28 				| Indonesia | Indonesia           | PASSED |
| 29 				| Indonesia | Indonesia           | PASSED |


Language: *th*
| android version | context  | applicationContext | status |
| ----------------|----------|--------------------|--------|
| 19 			  | Thailand | Thailand           | PASSED |
| 21 			  | Thailand | Thailand           | PASSED |
| 23 			  | Thailand | Thailand           | PASSED |
| 26 			  | Thailand | Thailand           | PASSED |
| 27 			  | Thailand | Thailand           | PASSED |
| 28 			  | Thailand | Thailand           | PASSED |
| 29 			  | Thailand | Thailand           | PASSED |