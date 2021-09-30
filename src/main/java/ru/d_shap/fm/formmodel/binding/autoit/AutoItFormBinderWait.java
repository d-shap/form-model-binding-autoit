///////////////////////////////////////////////////////////////////////////////////////////////////
// Form model AutoIt binding is a form model binding implementation for AutoIt.
// Copyright (C) 2018 Dmitry Shapovalov.
//
// This file is part of form model AutoIt binding.
//
// Form model AutoIt binding is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Form model AutoIt binding is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with this program. If not, see <http://www.gnu.org/licenses/>.
///////////////////////////////////////////////////////////////////////////////////////////////////
package ru.d_shap.fm.formmodel.binding.autoit;

import ru.d_shap.fm.formmodel.Messages;
import ru.d_shap.fm.formmodel.binding.FormBinder;
import ru.d_shap.fm.formmodel.binding.FormBindingException;
import ru.d_shap.fm.formmodel.definition.model.FormDefinition;

/**
 * AutoIt form binder wait.
 *
 * @param <T> the generic type of the result.
 *
 * @author Dmitry Shapovalov
 */
final class AutoItFormBinderWait<T> {

    private final FormBinder _formBinder;

    private final AutoItBindingSource _autoItBindingSource;

    private final BindAttempt<T> _bindAttempt;

    private final FormDefinition _formDefinition;

    private final long _timeOutInSeconds;

    private final long _sleepInMillis;

    AutoItFormBinderWait(final FormBinder formBinder, final AutoItBindingSource autoItBindingSource, final BindAttempt<T> bindAttempt, final FormDefinition formDefinition, final long timeOutInSeconds, final long sleepInMillis) {
        super();
        _formBinder = formBinder;
        _autoItBindingSource = autoItBindingSource;
        _bindAttempt = bindAttempt;
        _formDefinition = formDefinition;
        _timeOutInSeconds = timeOutInSeconds;
        _sleepInMillis = sleepInMillis;
    }

    T bind() {
        long endTimeMillis = System.currentTimeMillis() + _timeOutInSeconds * 1000;
        FormBindingException lastFormBindingException = null;
        while (true) {
            try {
                return _bindAttempt.tryBind(_formBinder, _autoItBindingSource);
            } catch (FormBindingException ex) {
                lastFormBindingException = ex;
            }
            if (System.currentTimeMillis() < endTimeMillis) {
                try {
                    Thread.sleep(_sleepInMillis);
                } catch (InterruptedException ex) {
                    break;
                }
            } else {
                break;
            }
        }
        if (lastFormBindingException == null) {
            throw new FormBindingException(Messages.Binding.getFormIsNotPresentMessage(_formDefinition));
        } else {
            throw lastFormBindingException;
        }
    }

    /**
     * AutoIt form binder attempt.
     *
     * @param <T> the generic type of the result.
     *
     * @author Dmitry Shapovalov
     */
    interface BindAttempt<T> {

        T tryBind(FormBinder formBinder, AutoItBindingSource autoItBindingSource);

    }

}
