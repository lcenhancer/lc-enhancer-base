/*
 * Copyright (C) 2025-2030 LcEnhancer(https://github.com/lcenhancer).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.lcenhancer.base.proxy;

import io.github.lcenhancer.base.interfaces.ProxyPointInterceptor;
import io.github.lcenhancer.base.utils.AssertUtil;

import java.util.Objects;

/**
 * <p>ProxyPointParameterView is a parameter view
 * used for proxy point parameter augmentation.
 *
 * <p>ProxyPointParameterView is used for before-processing
 * on {@link ProxyPointInterceptor}.
 *
 * @author Jidcoo
 * @since 1.0.0
 */
public final class ProxyPointParameterView {

    /**
     * The parameter types.
     */
    private final Class<?>[] types;

    /**
     * The parameters.
     */
    private final Object[] params;

    /**
     * The parameters size.
     */
    private final int size;

    static final Object[] DEFAULT_NO_PARAM = new Object[0];

    /**
     * Create a ProxyPointParameterView instance.
     *
     * @param types  the parameter types.
     * @param params the real params.
     */
    public ProxyPointParameterView(Class<?>[] types, Object[] params) {
        AssertUtil.nonNull(types, "The param types cannot be null.");
        if (Objects.isNull(params)) params = DEFAULT_NO_PARAM;
        AssertUtil.isTrue(
                types.length == params.length,
                "The length of param types does not match the length of the params."
        );
        this.types = types;
        this.params = params;
        this.size = types.length;
    }

    /**
     * Return the parameters size.
     *
     * @return the parameters size.
     */
    public int getSize() {
        return size;
    }

    /**
     * Return the type of the parameter at the specified position.
     *
     * @param pos the parameter position.
     * @return the parameter type.
     */
    public Class<?> getParameterType(int pos) {
        AssertUtil.isTrue(pos >= 0 && pos < size, "Illegal parameter position.");
        return types[pos];
    }

    /**
     * Return the parameter at the specified position.
     *
     * @param pos the parameter position.
     * @return the parameter.
     */
    public Object getParameter(int pos) {
        AssertUtil.isTrue(pos >= 0 && pos < size, "Illegal parameter position.");
        return params[pos];
    }

    /**
     * Set parameter value for the specified location.
     *
     * @param pos   the parameter position.
     * @param value the parameter value.
     */
    public void setParameter(int pos, Object value) {
        AssertUtil.isTrue(pos >= 0 && pos < size, "Illegal parameter position.");
        if (Objects.nonNull(value)) {
            AssertUtil.equals(value.getClass(), types[pos], "Illegal parameter value type.");
        }
        params[pos] = value;
    }
}
