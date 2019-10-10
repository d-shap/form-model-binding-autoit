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
package ru.d_shap.formmodel.binding.autoit;

import ru.d_shap.formmodel.binding.model.BindedAttribute;

/**
 * The AutoIt binded attribute.
 *
 * @author Dmitry Shapovalov
 */
public interface AutoItBindedAttribute extends BindedAttribute {

    /**
     * Get the attribute name.
     *
     * @return the attribute name.
     */
    String getName();

    /**
     * Get the attribute value.
     *
     * @return the attribute value.
     */
    Object getValue();

    /**
     * Get the attribute value as boolean.
     *
     * @return the attribute value as boolean.
     */
    boolean isBooleanValue();

    /**
     * Get the attribute value as int.
     *
     * @return the attribute value as int.
     */
    int getIntValue();

    /**
     * Get the attribute value as string.
     *
     * @return the attribute value as string.
     */
    String getStringValue();

}
