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

/**
 * The AutoIt mouse button constants.
 *
 * @author Dmitry Shapovalov
 */
public enum AutoItMouseButton {

    LEFT("left"),

    MIDDLE("middle"),

    RIGHT("right");

    private final String _value;

    AutoItMouseButton(final String value) {
        _value = value;
    }

    String getValue() {
        return _value;
    }

}
