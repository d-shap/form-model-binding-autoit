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
package ru.d_shap.formmodel.binding.autoit;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ru.d_shap.formmodel.binding.FormBinder;
import ru.d_shap.formmodel.definition.model.FormDefinition;
import ru.d_shap.formmodel.definition.model.FormDefinitions;
import ru.d_shap.formmodel.document.DocumentLookup;
import ru.d_shap.formmodel.document.DocumentProcessor;

import autoitx4java.AutoItX;

/**
 * AutoIt form binder.
 *
 * @author Dmitry Shapovalov
 */
public final class AutoItFormBinder {

    private static final long DEFAULT_TIMEOUT_IN_SECONDS = 2;

    private static final long DEFAULT_SLEEP_IN_MILLIS = 200;

    private final FormDefinitions _formDefinitions;

    private final FormBinder _formBinder;

    private final DocumentLookup _documentLookup;

    /**
     * Create new object.
     *
     * @param formDefinitions container for all form definitions.
     */
    public AutoItFormBinder(final FormDefinitions formDefinitions) {
        super();
        _formDefinitions = formDefinitions;
        _formBinder = new FormBinder(_formDefinitions, new AutoItFormInstanceBinder());
        _documentLookup = DocumentLookup.getDocumentLookup();
    }

    /**
     * Bind the specified form definition with the AutoIt source.
     *
     * @param autoItX     the AutoIt.
     * @param windowTitle the title of the window to access.
     * @param id          the specified form's ID.
     *
     * @return the binding result.
     */
    public Document bind(final AutoItX autoItX, final String windowTitle, final String id) {
        return bind(autoItX, windowTitle, id, DEFAULT_TIMEOUT_IN_SECONDS, DEFAULT_SLEEP_IN_MILLIS);
    }

    /**
     * Bind the specified form definition with the AutoIt source.
     *
     * @param autoItX          the AutoIt.
     * @param windowTitle      the title of the window to access.
     * @param id               the specified form's ID.
     * @param timeOutInSeconds the timeout in seconds when an expectation is called.
     * @param sleepInMillis    the duration in milliseconds to sleep between polls.
     *
     * @return the binding result.
     */
    public Document bind(final AutoItX autoItX, final String windowTitle, final String id, final long timeOutInSeconds, final long sleepInMillis) {
        AutoItBindingSource autoItBindingSource = new AutoItBindingSourceImpl(autoItX, windowTitle);
        AutoItFormBinderWait.BindAttempt<Document> bindAttempt = new DocumentBindAttemptId(id);
        FormDefinition formDefinition = _formDefinitions.getFormDefinition(id);
        AutoItFormBinderWait<Document> autoItFormBinderWait = new AutoItFormBinderWait<>(_formBinder, autoItBindingSource, bindAttempt, formDefinition, timeOutInSeconds, sleepInMillis);
        return autoItFormBinderWait.bind();
    }

    /**
     * Bind the specified form definition with the AutoIt source.
     *
     * @param autoItX     the AutoIt.
     * @param windowTitle the title of the window to access.
     * @param group       the specified form's group.
     * @param id          the specified form's ID.
     *
     * @return the binding result.
     */
    public Document bind(final AutoItX autoItX, final String windowTitle, final String group, final String id) {
        return bind(autoItX, windowTitle, group, id, DEFAULT_TIMEOUT_IN_SECONDS, DEFAULT_SLEEP_IN_MILLIS);
    }

    /**
     * Bind the specified form definition with the AutoIt source.
     *
     * @param autoItX          the AutoIt.
     * @param windowTitle      the title of the window to access.
     * @param group            the specified form's group.
     * @param id               the specified form's ID.
     * @param timeOutInSeconds the timeout in seconds when an expectation is called.
     * @param sleepInMillis    the duration in milliseconds to sleep between polls.
     *
     * @return the binding result.
     */
    public Document bind(final AutoItX autoItX, final String windowTitle, final String group, final String id, final long timeOutInSeconds, final long sleepInMillis) {
        AutoItBindingSource autoItBindingSource = new AutoItBindingSourceImpl(autoItX, windowTitle);
        AutoItFormBinderWait.BindAttempt<Document> bindAttempt = new DocumentBindAttemptGroupAndId(group, id);
        FormDefinition formDefinition = _formDefinitions.getFormDefinition(group, id);
        AutoItFormBinderWait<Document> autoItFormBinderWait = new AutoItFormBinderWait<>(_formBinder, autoItBindingSource, bindAttempt, formDefinition, timeOutInSeconds, sleepInMillis);
        return autoItFormBinderWait.bind();
    }

    /**
     * Bind the specified form definition with the AutoIt source.
     *
     * @param autoItX           the AutoIt.
     * @param windowTitle       the title of the window to access.
     * @param id                the specified form's ID.
     * @param documentProcessor the document processor.
     * @param <T>               the generic type of the result of the document processing.
     *
     * @return the result of the document processing.
     */
    public <T> T bind(final AutoItX autoItX, final String windowTitle, final String id, final DocumentProcessor<T> documentProcessor) {
        return bind(autoItX, windowTitle, id, DEFAULT_TIMEOUT_IN_SECONDS, DEFAULT_SLEEP_IN_MILLIS, documentProcessor);
    }

    /**
     * Bind the specified form definition with the AutoIt source.
     *
     * @param autoItX           the AutoIt.
     * @param windowTitle       the title of the window to access.
     * @param id                the specified form's ID.
     * @param timeOutInSeconds  the timeout in seconds when an expectation is called.
     * @param sleepInMillis     the duration in milliseconds to sleep between polls.
     * @param documentProcessor the document processor.
     * @param <T>               the generic type of the result of the document processing.
     *
     * @return the result of the document processing.
     */
    public <T> T bind(final AutoItX autoItX, final String windowTitle, final String id, final long timeOutInSeconds, final long sleepInMillis, final DocumentProcessor<T> documentProcessor) {
        AutoItBindingSource autoItBindingSource = new AutoItBindingSourceImpl(autoItX, windowTitle);
        AutoItFormBinderWait.BindAttempt<T> bindAttempt = new DocumentProcessorBindAttemptId<>(id, documentProcessor);
        FormDefinition formDefinition = _formDefinitions.getFormDefinition(id);
        AutoItFormBinderWait<T> autoItFormBinderWait = new AutoItFormBinderWait<>(_formBinder, autoItBindingSource, bindAttempt, formDefinition, timeOutInSeconds, sleepInMillis);
        return autoItFormBinderWait.bind();
    }

    /**
     * Bind the specified form definition with the AutoIt source.
     *
     * @param autoItX           the AutoIt.
     * @param windowTitle       the title of the window to access.
     * @param group             the specified form's group.
     * @param id                the specified form's ID.
     * @param documentProcessor the document processor.
     * @param <T>               the generic type of the result of the document processing.
     *
     * @return the result of the document processing.
     */
    public <T> T bind(final AutoItX autoItX, final String windowTitle, final String group, final String id, final DocumentProcessor<T> documentProcessor) {
        return bind(autoItX, windowTitle, group, id, DEFAULT_TIMEOUT_IN_SECONDS, DEFAULT_SLEEP_IN_MILLIS, documentProcessor);
    }

    /**
     * Bind the specified form definition with the AutoIt source.
     *
     * @param autoItX           the AutoIt.
     * @param windowTitle       the title of the window to access.
     * @param group             the specified form's group.
     * @param id                the specified form's ID.
     * @param timeOutInSeconds  the timeout in seconds when an expectation is called.
     * @param sleepInMillis     the duration in milliseconds to sleep between polls.
     * @param documentProcessor the document processor.
     * @param <T>               the generic type of the result of the document processing.
     *
     * @return the result of the document processing.
     */
    public <T> T bind(final AutoItX autoItX, final String windowTitle, final String group, final String id, final long timeOutInSeconds, final long sleepInMillis, final DocumentProcessor<T> documentProcessor) {
        AutoItBindingSource autoItBindingSource = new AutoItBindingSourceImpl(autoItX, windowTitle);
        AutoItFormBinderWait.BindAttempt<T> bindAttempt = new DocumentProcessorBindAttemptGroupAndId<>(group, id, documentProcessor);
        FormDefinition formDefinition = _formDefinitions.getFormDefinition(group, id);
        AutoItFormBinderWait<T> autoItFormBinderWait = new AutoItFormBinderWait<>(_formBinder, autoItBindingSource, bindAttempt, formDefinition, timeOutInSeconds, sleepInMillis);
        return autoItFormBinderWait.bind();
    }

    /**
     * Bind the specified form definition with the AutoIt source.
     *
     * @param autoItX     the AutoIt.
     * @param windowTitle the title of the window to access.
     * @param windowText  the text of the window to access.
     * @param id          the specified form's ID.
     *
     * @return the binding result.
     */
    public Document bindWithText(final AutoItX autoItX, final String windowTitle, final String windowText, final String id) {
        return bindWithText(autoItX, windowTitle, windowText, id, DEFAULT_TIMEOUT_IN_SECONDS, DEFAULT_SLEEP_IN_MILLIS);
    }

    /**
     * Bind the specified form definition with the AutoIt source.
     *
     * @param autoItX          the AutoIt.
     * @param windowTitle      the title of the window to access.
     * @param windowText       the text of the window to access.
     * @param id               the specified form's ID.
     * @param timeOutInSeconds the timeout in seconds when an expectation is called.
     * @param sleepInMillis    the duration in milliseconds to sleep between polls.
     *
     * @return the binding result.
     */
    public Document bindWithText(final AutoItX autoItX, final String windowTitle, final String windowText, final String id, final long timeOutInSeconds, final long sleepInMillis) {
        AutoItBindingSource autoItBindingSource = new AutoItBindingSourceImpl(autoItX, windowTitle, windowText);
        AutoItFormBinderWait.BindAttempt<Document> bindAttempt = new DocumentBindAttemptId(id);
        FormDefinition formDefinition = _formDefinitions.getFormDefinition(id);
        AutoItFormBinderWait<Document> autoItFormBinderWait = new AutoItFormBinderWait<>(_formBinder, autoItBindingSource, bindAttempt, formDefinition, timeOutInSeconds, sleepInMillis);
        return autoItFormBinderWait.bind();
    }

    /**
     * Bind the specified form definition with the AutoIt source.
     *
     * @param autoItX     the AutoIt.
     * @param windowTitle the title of the window to access.
     * @param windowText  the text of the window to access.
     * @param group       the specified form's group.
     * @param id          the specified form's ID.
     *
     * @return the binding result.
     */
    public Document bindWithText(final AutoItX autoItX, final String windowTitle, final String windowText, final String group, final String id) {
        return bindWithText(autoItX, windowTitle, windowText, group, id, DEFAULT_TIMEOUT_IN_SECONDS, DEFAULT_SLEEP_IN_MILLIS);
    }

    /**
     * Bind the specified form definition with the AutoIt source.
     *
     * @param autoItX          the AutoIt.
     * @param windowTitle      the title of the window to access.
     * @param windowText       the text of the window to access.
     * @param group            the specified form's group.
     * @param id               the specified form's ID.
     * @param timeOutInSeconds the timeout in seconds when an expectation is called.
     * @param sleepInMillis    the duration in milliseconds to sleep between polls.
     *
     * @return the binding result.
     */
    public Document bindWithText(final AutoItX autoItX, final String windowTitle, final String windowText, final String group, final String id, final long timeOutInSeconds, final long sleepInMillis) {
        AutoItBindingSource autoItBindingSource = new AutoItBindingSourceImpl(autoItX, windowTitle, windowText);
        AutoItFormBinderWait.BindAttempt<Document> bindAttempt = new DocumentBindAttemptGroupAndId(group, id);
        FormDefinition formDefinition = _formDefinitions.getFormDefinition(group, id);
        AutoItFormBinderWait<Document> autoItFormBinderWait = new AutoItFormBinderWait<>(_formBinder, autoItBindingSource, bindAttempt, formDefinition, timeOutInSeconds, sleepInMillis);
        return autoItFormBinderWait.bind();
    }

    /**
     * Bind the specified form definition with the AutoIt source.
     *
     * @param autoItX           the AutoIt.
     * @param windowTitle       the title of the window to access.
     * @param windowText        the text of the window to access.
     * @param id                the specified form's ID.
     * @param documentProcessor the document processor.
     * @param <T>               the generic type of the result of the document processing.
     *
     * @return the result of the document processing.
     */
    public <T> T bindWithText(final AutoItX autoItX, final String windowTitle, final String windowText, final String id, final DocumentProcessor<T> documentProcessor) {
        return bindWithText(autoItX, windowTitle, windowText, id, DEFAULT_TIMEOUT_IN_SECONDS, DEFAULT_SLEEP_IN_MILLIS, documentProcessor);
    }

    /**
     * Bind the specified form definition with the AutoIt source.
     *
     * @param autoItX           the AutoIt.
     * @param windowTitle       the title of the window to access.
     * @param windowText        the text of the window to access.
     * @param id                the specified form's ID.
     * @param timeOutInSeconds  the timeout in seconds when an expectation is called.
     * @param sleepInMillis     the duration in milliseconds to sleep between polls.
     * @param documentProcessor the document processor.
     * @param <T>               the generic type of the result of the document processing.
     *
     * @return the result of the document processing.
     */
    public <T> T bindWithText(final AutoItX autoItX, final String windowTitle, final String windowText, final String id, final long timeOutInSeconds, final long sleepInMillis, final DocumentProcessor<T> documentProcessor) {
        AutoItBindingSource autoItBindingSource = new AutoItBindingSourceImpl(autoItX, windowTitle, windowText);
        AutoItFormBinderWait.BindAttempt<T> bindAttempt = new DocumentProcessorBindAttemptId<>(id, documentProcessor);
        FormDefinition formDefinition = _formDefinitions.getFormDefinition(id);
        AutoItFormBinderWait<T> autoItFormBinderWait = new AutoItFormBinderWait<>(_formBinder, autoItBindingSource, bindAttempt, formDefinition, timeOutInSeconds, sleepInMillis);
        return autoItFormBinderWait.bind();
    }

    /**
     * Bind the specified form definition with the AutoIt source.
     *
     * @param autoItX           the AutoIt.
     * @param windowTitle       the title of the window to access.
     * @param windowText        the text of the window to access.
     * @param group             the specified form's group.
     * @param id                the specified form's ID.
     * @param documentProcessor the document processor.
     * @param <T>               the generic type of the result of the document processing.
     *
     * @return the result of the document processing.
     */
    public <T> T bindWithText(final AutoItX autoItX, final String windowTitle, final String windowText, final String group, final String id, final DocumentProcessor<T> documentProcessor) {
        return bindWithText(autoItX, windowTitle, windowText, group, id, DEFAULT_TIMEOUT_IN_SECONDS, DEFAULT_SLEEP_IN_MILLIS, documentProcessor);
    }

    /**
     * Bind the specified form definition with the AutoIt source.
     *
     * @param autoItX           the AutoIt.
     * @param windowTitle       the title of the window to access.
     * @param windowText        the text of the window to access.
     * @param group             the specified form's group.
     * @param id                the specified form's ID.
     * @param timeOutInSeconds  the timeout in seconds when an expectation is called.
     * @param sleepInMillis     the duration in milliseconds to sleep between polls.
     * @param documentProcessor the document processor.
     * @param <T>               the generic type of the result of the document processing.
     *
     * @return the result of the document processing.
     */
    public <T> T bindWithText(final AutoItX autoItX, final String windowTitle, final String windowText, final String group, final String id, final long timeOutInSeconds, final long sleepInMillis, final DocumentProcessor<T> documentProcessor) {
        AutoItBindingSource autoItBindingSource = new AutoItBindingSourceImpl(autoItX, windowTitle, windowText);
        AutoItFormBinderWait.BindAttempt<T> bindAttempt = new DocumentProcessorBindAttemptGroupAndId<>(group, id, documentProcessor);
        FormDefinition formDefinition = _formDefinitions.getFormDefinition(group, id);
        AutoItFormBinderWait<T> autoItFormBinderWait = new AutoItFormBinderWait<>(_formBinder, autoItBindingSource, bindAttempt, formDefinition, timeOutInSeconds, sleepInMillis);
        return autoItFormBinderWait.bind();
    }

    /**
     * Perform lookup and return the XML elements found.
     *
     * @param node   the source node.
     * @param lookup the XPath lookup expression.
     *
     * @return the XML elements found.
     */
    public List<Element> getElements(final Node node, final String lookup) {
        return _documentLookup.getElements(node, lookup);
    }

    /**
     * Perform lookup and return the XML elements with the specified ID.
     *
     * @param node the source node.
     * @param id   the specified ID.
     *
     * @return the XML elements found.
     */
    public List<Element> getElementsWithId(final Node node, final String id) {
        return _documentLookup.getElementsWithId(node, id);
    }

    /**
     * Perform lookup and return the XML elements with the specified attribute value for the specified attribute name.
     *
     * @param node           the source node.
     * @param attributeName  the specified attribute name.
     * @param attributeValue the specified attribute value.
     *
     * @return the XML elements found.
     */
    public List<Element> getElementsWithAttribute(final Node node, final String attributeName, final String attributeValue) {
        return _documentLookup.getElementsWithAttribute(node, attributeName, attributeValue);
    }

    /**
     * Obtain the binded elements from the specified XML elements.
     *
     * @param elements the specified XML elements.
     *
     * @return the binded elements.
     */
    public List<AutoItBindedElement> getBindedElements(final List<Element> elements) {
        return _documentLookup.getBindedElements(elements, AutoItBindedElement.class);
    }

    /**
     * Perform lookup and return the binded elements found.
     *
     * @param node   the source node.
     * @param lookup the XPath lookup expression.
     *
     * @return the binded elements.
     */
    public List<AutoItBindedElement> getBindedElements(final Node node, final String lookup) {
        List<Element> elements = getElements(node, lookup);
        return getBindedElements(elements);
    }

    /**
     * Perform lookup and return the binded elements with the specified ID.
     *
     * @param node the source node.
     * @param id   the specified ID.
     *
     * @return the binded elements.
     */
    public List<AutoItBindedElement> getBindedElementsWithId(final Node node, final String id) {
        List<Element> elements = getElementsWithId(node, id);
        return getBindedElements(elements);
    }

    /**
     * Perform lookup and return the binded elements with the specified attribute value for the specified attribute name.
     *
     * @param node           the source node.
     * @param attributeName  the specified attribute name.
     * @param attributeValue the specified attribute value.
     *
     * @return the binded elements.
     */
    public List<AutoItBindedElement> getBindedElementsWithAttribute(final Node node, final String attributeName, final String attributeValue) {
        List<Element> elements = getElementsWithAttribute(node, attributeName, attributeValue);
        return getBindedElements(elements);
    }

    /**
     * Perform lookup and return the first binded element found.
     *
     * @param node   the source node.
     * @param lookup the XPath lookup expression.
     *
     * @return the first binded element.
     */
    public AutoItBindedElement getBindedElement(final Node node, final String lookup) {
        List<AutoItBindedElement> bindedElements = getBindedElements(node, lookup);
        if (bindedElements.isEmpty()) {
            return null;
        } else {
            return bindedElements.get(0);
        }
    }

    /**
     * Perform lookup and return the first binded element with the specified ID.
     *
     * @param node the source node.
     * @param id   the specified ID.
     *
     * @return the first binded element.
     */
    public AutoItBindedElement getBindedElementWithId(final Node node, final String id) {
        List<AutoItBindedElement> bindedElements = getBindedElementsWithId(node, id);
        if (bindedElements.isEmpty()) {
            return null;
        } else {
            return bindedElements.get(0);
        }
    }

    /**
     * Perform lookup and return the first binded element with the specified attribute value for the specified attribute name.
     *
     * @param node           the source node.
     * @param attributeName  the specified attribute name.
     * @param attributeValue the specified attribute value.
     *
     * @return the first binded element.
     */
    public AutoItBindedElement getBindedElementWithAttribute(final Node node, final String attributeName, final String attributeValue) {
        List<AutoItBindedElement> bindedElements = getBindedElementsWithAttribute(node, attributeName, attributeValue);
        if (bindedElements.isEmpty()) {
            return null;
        } else {
            return bindedElements.get(0);
        }
    }

    /**
     * Obtain the binded attributes from the specified XML elements.
     *
     * @param elements the specified XML elements.
     *
     * @return the binded attributes.
     */
    public List<AutoItBindedAttribute> getBindedAttributes(final List<Element> elements) {
        return _documentLookup.getBindedAttributes(elements, AutoItBindedAttribute.class);
    }

    /**
     * AutoIt bind attempt for the form definition, identified by the form's ID.
     *
     * @author Dmitry Shapovalov
     */
    private static final class DocumentBindAttemptId implements AutoItFormBinderWait.BindAttempt<Document> {

        private final String _id;

        DocumentBindAttemptId(final String id) {
            super();
            _id = id;
        }

        @Override
        public Document tryBind(final FormBinder formBinder, final AutoItBindingSource autoItBindingSource) {
            return formBinder.bind(autoItBindingSource, _id);
        }

    }

    /**
     * AutoIt bind attempt for the form definition, identified by the form's group and form's ID.
     *
     * @author Dmitry Shapovalov
     */
    private static final class DocumentBindAttemptGroupAndId implements AutoItFormBinderWait.BindAttempt<Document> {

        private final String _group;

        private final String _id;

        DocumentBindAttemptGroupAndId(final String group, final String id) {
            super();
            _group = group;
            _id = id;
        }

        @Override
        public Document tryBind(final FormBinder formBinder, final AutoItBindingSource autoItBindingSource) {
            return formBinder.bind(autoItBindingSource, _group, _id);
        }

    }

    /**
     * AutoIt bind and process attempt for the form definition, identified by the form's ID.
     *
     * @param <T> the generic type of the result.
     *
     * @author Dmitry Shapovalov
     */
    private static final class DocumentProcessorBindAttemptId<T> implements AutoItFormBinderWait.BindAttempt<T> {

        private final String _id;

        private final DocumentProcessor<T> _documentProcessor;

        DocumentProcessorBindAttemptId(final String id, final DocumentProcessor<T> documentProcessor) {
            super();
            _id = id;
            _documentProcessor = documentProcessor;
        }

        @Override
        public T tryBind(final FormBinder formBinder, final AutoItBindingSource autoItBindingSource) {
            return formBinder.bind(autoItBindingSource, _id, _documentProcessor);
        }

    }

    /**
     * AutoIt bind and process attempt for the form definition, identified by the form's group and form's ID.
     *
     * @param <T> the generic type of the result.
     *
     * @author Dmitry Shapovalov
     */
    private static final class DocumentProcessorBindAttemptGroupAndId<T> implements AutoItFormBinderWait.BindAttempt<T> {

        private final String _group;

        private final String _id;

        private final DocumentProcessor<T> _documentProcessor;

        DocumentProcessorBindAttemptGroupAndId(final String group, final String id, final DocumentProcessor<T> documentProcessor) {
            super();
            _group = group;
            _id = id;
            _documentProcessor = documentProcessor;
        }

        @Override
        public T tryBind(final FormBinder formBinder, final AutoItBindingSource autoItBindingSource) {
            return formBinder.bind(autoItBindingSource, _group, _id, _documentProcessor);
        }

    }

}
