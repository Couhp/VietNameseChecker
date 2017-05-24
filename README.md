VietNamese Checker

Check if a word is VietNamese or English (VietNamese without diacritic is not accepted) 
Add src and resource files to your project

```
	CheckVN checker = new CheckVN();
	
	String sample = "Xin chào";
	
	checker.isVN(sample); //true
	
	sample = "hello";
	checker.isVN(sample); //false
```	
