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

import autoitx4java.AutoItX;

/**
 * The AutoIt binding source implementation.
 *
 * @author Dmitry Shapovalov
 */
final class AutoItBindingSourceImpl implements AutoItBindingSource {

    private final AutoItX _autoItX;

    private final String _windowTitle;

    private final String _windowText;

    AutoItBindingSourceImpl(final AutoItX autoItX, final String windowTitle) {
        super();
        _autoItX = autoItX;
        _windowTitle = windowTitle;
        _windowText = "";
    }

    AutoItBindingSourceImpl(final AutoItX autoItX, final String windowTitle, final String windowText) {
        super();
        _autoItX = autoItX;
        _windowTitle = windowTitle;
        _windowText = windowText;
    }

    @Override
    public AutoItX getAutoIt() {
        return _autoItX;
    }

    @Override
    public String getWindowTitle() {
        return _windowTitle;
    }

    @Override
    public String getWindowText() {
        return _windowText;
    }

}
