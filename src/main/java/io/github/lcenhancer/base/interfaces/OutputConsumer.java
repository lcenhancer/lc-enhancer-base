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

package io.github.lcenhancer.base.interfaces;

/**
 * <p>OutputConsumer is an output consumer. </p>
 * <p>It will consume a string method output source. </p>
 *
 * @author Jidcoo
 * @apiNote Please do not forget to implement the
 *          {@link #close()} method for {@link AutoCloseable}.
 *          We will call the {@link #close()} method
 *          at the appropriate time to close
 *          the resources used.
 * @since 1.0.0
 */
public interface OutputConsumer extends AutoCloseable, Order {

    /**
     * Consume a string output from method calls.
     *
     * @param output a string output.
     */
    void consumeNextOutput(String output);
}
