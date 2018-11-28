///////////////////////////////////////////////////////////////////////////////////////////////////
// Form model autoit binding is a form model binding implementation for AutoIt.
// Copyright (C) 2018 Dmitry Shapovalov.
//
// This file is part of form model autoit binding.
//
// Form model autoit binding is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Form model autoit binding is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with this program. If not, see <http://www.gnu.org/licenses/>.
///////////////////////////////////////////////////////////////////////////////////////////////////
/**
 * <p>
 * Form model autoit binding is a form model binding implementation for AutoIt.
 * </p>
 * <p>
 * Form model autoit binding is a wrapper for AutoIt scripts. It provides facilities to describe
 * the application's GUI, to bind this description with the application and to automate the application
 * through the binded description.
 * </p>
 * <p>
 * The benefit is in enhancing script maintenance and reducing code duplication. So if the GUI changes,
 * the script themselves don’t need to change, only the GUI definition needs to change. Subsequently
 * all changes to support that new GUI are located in one place.
 * </p>
 * <p>
 * The application's GUI is described in the form definition XML. Then this form definition is binded
 * with the application's GUI and the result of this binding is a binded form. Binded elements can be
 * obtained by the application from this binded form. Script uses this binded elements to automate the
 * application.
 * </p>
 * <p>
 * For example, suppose the Windows Calculator application.
 * </p>
 * <p>
 * The model for this application is the following (for Windows 7):
 * </p>
 * <pre>
 * &lt;?xml version="1.0"?&gt;
 * &lt;ns1:form id="calc" xmlns:ns1="http://d-shap.ru/schema/form-model/1.0"&gt;
 *     &lt;ns1:element id="button0" lookup="130"/&gt;
 *     &lt;ns1:element id="button1" lookup="131"/&gt;
 *     &lt;ns1:element id="button2" lookup="132"/&gt;
 *     &lt;ns1:element id="button3" lookup="133"/&gt;
 *     &lt;ns1:element id="button4" lookup="134"/&gt;
 *     &lt;ns1:element id="button5" lookup="135"/&gt;
 *     &lt;ns1:element id="button6" lookup="136"/&gt;
 *     &lt;ns1:element id="button7" lookup="137"/&gt;
 *     &lt;ns1:element id="button8" lookup="138"/&gt;
 *     &lt;ns1:element id="button9" lookup="139"/&gt;
 *     &lt;ns1:element id="buttonPlus" lookup="93"/&gt;
 *     &lt;ns1:element id="buttonMinus" lookup="94"/&gt;
 *     &lt;ns1:element id="buttonMult" lookup="92"/&gt;
 *     &lt;ns1:element id="buttonDiv" lookup="91"/&gt;
 *     &lt;ns1:element id="buttonEquals" lookup="121"/&gt;
 *     &lt;ns1:element id="textResult" lookup="150"/&gt;
 * &lt;/ns1:form&gt;
 * </pre>
 * <p>
 * The following code implements the binding and the application automation:
 * </p>
 * <pre>{@code
 * // Load form definitions
 * FormDefinitions formDefinitions = new FormDefinitions();
 * File file = new File("file with the form definition");
 * FormDefinitionsLoader formDefinitionsLoader = new FormXmlDefinitionsFileLoader(file);
 * formDefinitionsLoader.load(formDefinitions);
 * AutoItFormBinder formBinder = new AutoItFormBinder(formDefinitions);
 *
 * // Create AutoIt object and run the application
 * System.setProperty(LibraryLoader.JACOB_DLL_PATH, "/path/to/jacob/dll");
 * AutoItX autoItX = new AutoItX();
 * autoItX.run("calc.exe");
 *
 * // Bind the application
 * Document document = formBinder.bind(autoItX, "Calculator", "calc");
 *
 * // Automate the application
 * formBinder.getBindedElementWithId(document, "button3").click();
 * formBinder.getBindedElementWithId(document, "buttonMinus").click();
 * formBinder.getBindedElementWithId(document, "button6").click();
 * formBinder.getBindedElementWithId(document, "buttonEquals").click();
 * System.out.println(formBinder.getBindedElementWithId(document, "textResult").getText());
 *
 * // Close the application
 * autoItX.winClose("Calculator");
 * }</pre>
 */
package ru.d_shap.formmodel.binding.autoit;
