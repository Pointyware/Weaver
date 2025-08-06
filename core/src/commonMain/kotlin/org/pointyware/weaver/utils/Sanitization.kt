/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Affero GPL-3.0 license. See project root for full text.
 */

package org.pointyware.weaver.utils

/**
 * Transforms the input to conform with our rules for HTML pages.
 *
 * 1. An html file must end with .html
 * 2. All whitespaces are replaced with underscores
 */
fun sanitizeHtmlFileName(input: String): String =
    input.replace("\\s".toRegex(), "_").let {
        if (it.endsWith(".html")) {
            it
        } else {
            "$it.html"
        }
    }
