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

package io.github.lcenhancer.base.impl.io;

import io.github.lcenhancer.base.interfaces.InputProvider;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

/**
 * <p>FileInputProvider is a {@link InputProvider} and
 * extends on {@link BaseBufferReaderInputProvider}.</p>
 *
 * <p>FileInputProvider use the {@link InputStream}
 * or the {@link File} as input source.
 * </p>
 *
 * @author Jidcoo
 * @since 1.0.0
 */
public class FileInputProvider extends BaseBufferReaderInputProvider {

    /**
     * Create a FileInputProvider by abstract input stream.
     *
     * @param inputStream the input stream.
     */
    public FileInputProvider(InputStream inputStream) {
        super(inputStream);
    }

    /**
     * Create a FileInputProvider by file.
     *
     * @param file the file.
     */
    public FileInputProvider(File file) throws IOException {
        this(Files.newInputStream(file.toPath()));
    }

    /**
     * Create a FileInputProvider by file path.
     *
     * @param filePath the file path.
     */
    public FileInputProvider(String filePath) throws IOException {
        this(new File(filePath));
    }
}
