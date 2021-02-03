/*
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package com.intellij.psi

/**
 * The original PsiElement (from IJ) is needed to specify generated diagnostic psi element type
 * But but for some reason project with with dependency to intellijCoreDep is not properly imported within IJ
 * So, this is a temporary hack to allow using PsiElement::class
 * Will be removed as the issue will be fixed
 */
interface PsiElement


interface PsiTypeElement