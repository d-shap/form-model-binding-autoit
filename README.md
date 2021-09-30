# Form model AutoIt binding
Form model AutoIt binding is a form model binding implementation for AutoIt.

Form model AutoIt binding is a wrapper for the AutoIt scripts.
It provides facilities to describe the application's GUI, to bind this description with the application and to automate the application through the binded description.

The benefit is in enhancing script maintenance and reducing code duplication.
So if the GUI changes, the script themselves don’t need to change, only the GUI definition needs to change.
Subsequently, all changes to support that new GUI are located in one place.

The application's GUI is described in the form definition XML.
Then this form definition is binded with the application's GUI and the result of this binding is a binded form.
Binded elements can be obtained by the application from this binded form.
Script uses this binded elements to automate the application.

For example, suppose the Windows Calculator application.

The model for this application is the following (for Windows 7):
```
<?xml version="1.0"?>
<ns1:form id="calc" xmlns:ns1="http://d-shap.ru/schema/form-model/1.0">
    <ns1:element id="button0" lookup="130"/>
    <ns1:element id="button1" lookup="131"/>
    <ns1:element id="button2" lookup="132"/>
    <ns1:element id="button3" lookup="133"/>
    <ns1:element id="button4" lookup="134"/>
    <ns1:element id="button5" lookup="135"/>
    <ns1:element id="button6" lookup="136"/>
    <ns1:element id="button7" lookup="137"/>
    <ns1:element id="button8" lookup="138"/>
    <ns1:element id="button9" lookup="139"/>
    <ns1:element id="buttonPlus" lookup="93"/>
    <ns1:element id="buttonMinus" lookup="94"/>
    <ns1:element id="buttonMult" lookup="92"/>
    <ns1:element id="buttonDiv" lookup="91"/>
    <ns1:element id="buttonEquals" lookup="121"/>
    <ns1:element id="textResult" lookup="150"/>
</ns1:form>
```

The following code implements the binding and the application automation:
```
// Load form definitions
FormDefinitions formDefinitions = new FormDefinitions();
File file = new File("file with the form definition");
FormDefinitionsLoader formDefinitionsLoader = new FormXmlDefinitionsFileLoader(file);
formDefinitionsLoader.load(formDefinitions);
AutoItFormBinder formBinder = new AutoItFormBinder(formDefinitions);

// Create AutoIt object and run the application
System.setProperty(LibraryLoader.JACOB_DLL_PATH, "/path/to/jacob/dll");
AutoItX autoItX = new AutoItX();
autoItX.run("calc.exe");

// Bind the application
Document document = formBinder.bind(autoItX, "Calculator", "calc");

// Automate the application
formBinder.getBindedElementWithId(document, "button3").click();
formBinder.getBindedElementWithId(document, "buttonMinus").click();
formBinder.getBindedElementWithId(document, "button6").click();
formBinder.getBindedElementWithId(document, "buttonEquals").click();
System.out.println(formBinder.getBindedElementWithId(document, "textResult").getText());

// Close the application
autoItX.winClose("Calculator");
```

# XML definition
Namespace: ```http://d-shap.ru/schema/form-model/1.0```

## form
The top-level element. Defines the form.

Attributes:
* ```group``` - the form's group, optional
* ```id``` - the form's ID, mandatory

Attributes ```group``` and ```id``` identify the form and should be unique.

Child elements:
* ```element```
* ```single-element```
* ```form-reference```

## element
Element is a form part, that make sence for the application.

Attributes:
* ```id``` - the element's ID, optional
* ```lookup``` - the element's lookup string, used by the binding extension, mandatory
* ```type``` - the element's type, optional

Valid values for the ```type``` attribute depend on the parent element.
Possible values are:
* ```required``` - there should be exactly one element.
* ```required+``` - there should be at least one element.
* ```optional``` - there could be one element or no element at all.
* ```optional+``` - there could be more than one element or no element at all.
* ```prohibited``` - there should not be any element.

Child elements:
* ```attribute```
* ```element```
* ```single-element```
* ```form-reference```

## attribute
The element's attribute.

Attributes:
* ```id``` - the attribute's ID, optional
* ```lookup``` - the attribute's lookup string, used by the binding extension, mandatory
* ```type``` - the attribute's type, optional

Valid values for the ```type``` attribute depend on the parent element.
Possible values are:
* ```required``` - there should be exactly one element.
* ```optional``` - there could be one element or no element at all.
* ```prohibited``` - there should not be any element.

## single-element
Single element is a container for other elements.
Only one child element should present (but child element could be ```optional+```).

Attributes:
* ```id``` - the single element's ID, optional
* ```type``` - the single element's type, optional

Valid values for the ```type``` attribute depend on the parent element.
Possible values are:
* ```required``` - there should be exactly one element.
* ```optional``` - there could be one element or no element at all.
* ```prohibited``` - there should not be any element.

Child elements:
* ```element```
* ```single-element```

## form-reference
The reference to another form definition.
The elements of the referenced form are included in the current form as child elements of the ```form-reference``` element.

Attributes:
* ```group``` - the form's group, optional
* ```id``` - the form's ID, mandatory

# HOW TO
[HOW TO examples](HOWTO.md)

# The latest release
Form model library:
* **&lt;groupId&gt;**: ru.d-shap.fm
* **&lt;artifactId&gt;**: form-model
* **&lt;version&gt;**: 1.0

Form model AutoIt binding:
* **&lt;groupId&gt;**: ru.d-shap.fm
* **&lt;artifactId&gt;**: form-model-binding-autoit
* **&lt;version&gt;**: 1.0.0

# Donation
If you find my code useful, you can [bye me a coffee](https://www.paypal.me/dshapovalov)
