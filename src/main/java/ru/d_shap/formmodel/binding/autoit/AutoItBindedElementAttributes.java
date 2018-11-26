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

import java.util.HashMap;
import java.util.Map;

import autoitx4java.AutoItX;

/**
 * The AutoIt binded element attributes.
 *
 * @author Dmitry Shapovalov
 */
final class AutoItBindedElementAttributes {

    private static final String VISIBLE = "visible";

    private static final String ENABLED = "enabled";

    private static final String POSITION_X = "x";

    private static final String POSITION_Y = "y";

    private static final String WIDTH = "width";

    private static final String HEIGHT = "height";

    private static final Map<String, AutoItAttribute> ATTRIBUTES;

    static {
        ATTRIBUTES = new HashMap<>();
        ATTRIBUTES.put(VISIBLE, new AutoItControlAttributeVisible());
        ATTRIBUTES.put(ENABLED, new AutoItControlAttributeEnabled());
        ATTRIBUTES.put(POSITION_X, new AutoItControlAttributePositionX());
        ATTRIBUTES.put(POSITION_Y, new AutoItControlAttributePositionY());
        ATTRIBUTES.put(WIDTH, new AutoItControlAttributePositionWidth());
        ATTRIBUTES.put(HEIGHT, new AutoItControlAttributePositionHeight());
    }

    private AutoItBindedElementAttributes() {
        super();
    }

    static boolean hasAttribute(final String name) {
        return ATTRIBUTES.containsKey(name);
    }

    static Object getAttribute(final AutoItX autoItX, final String windowTitle, final String windowText, final String controlId, final String name) {
        return ATTRIBUTES.get(name).get(autoItX, windowTitle, windowText, controlId);
    }

    /**
     * The base AutoIt binded element's attribute class.
     *
     * @author Dmitry Shapovalov
     */
    private abstract static class AutoItAttribute {

        AutoItAttribute() {
            super();
        }

        abstract Object get(AutoItX autoItX, String windowTitle, String windowText, String controlId);

    }

    /**
     * The AutoIt binded element's attribute for "visible".
     *
     * @author Dmitry Shapovalov
     */
    private static final class AutoItControlAttributeVisible extends AutoItAttribute {

        AutoItControlAttributeVisible() {
            super();
        }

        @Override
        Object get(final AutoItX autoItX, final String windowTitle, final String windowText, final String controlId) {
            return autoItX.controlCommandIsVisible(windowTitle, windowText, controlId);
        }

    }

    /**
     * The AutoIt binded element's attribute for "enabled".
     *
     * @author Dmitry Shapovalov
     */
    private static final class AutoItControlAttributeEnabled extends AutoItAttribute {

        AutoItControlAttributeEnabled() {
            super();
        }

        @Override
        Object get(final AutoItX autoItX, final String windowTitle, final String windowText, final String controlId) {
            return autoItX.controlCommandIsEnabled(windowTitle, windowText, controlId);
        }

    }

    /**
     * The AutoIt binded element's attribute for "x".
     *
     * @author Dmitry Shapovalov
     */
    private static final class AutoItControlAttributePositionX extends AutoItAttribute {

        AutoItControlAttributePositionX() {
            super();
        }

        @Override
        Object get(final AutoItX autoItX, final String windowTitle, final String windowText, final String controlId) {
            return autoItX.controlGetPosX(windowTitle, windowText, controlId);
        }

    }

    /**
     * The AutoIt binded element's attribute for "y".
     *
     * @author Dmitry Shapovalov
     */
    private static final class AutoItControlAttributePositionY extends AutoItAttribute {

        AutoItControlAttributePositionY() {
            super();
        }

        @Override
        Object get(final AutoItX autoItX, final String windowTitle, final String windowText, final String controlId) {
            return autoItX.controlGetPosY(windowTitle, windowText, controlId);
        }

    }

    /**
     * The AutoIt binded element's attribute for "width".
     *
     * @author Dmitry Shapovalov
     */
    private static final class AutoItControlAttributePositionWidth extends AutoItAttribute {

        AutoItControlAttributePositionWidth() {
            super();
        }

        @Override
        Object get(final AutoItX autoItX, final String windowTitle, final String windowText, final String controlId) {
            return autoItX.controlGetPosWidth(windowTitle, windowText, controlId);
        }

    }

    /**
     * The AutoIt binded element's attribute for "height".
     *
     * @author Dmitry Shapovalov
     */
    private static final class AutoItControlAttributePositionHeight extends AutoItAttribute {

        AutoItControlAttributePositionHeight() {
            super();
        }

        @Override
        Object get(final AutoItX autoItX, final String windowTitle, final String windowText, final String controlId) {
            return autoItX.controlGetPosHeight(windowTitle, windowText, controlId);
        }

    }

}
