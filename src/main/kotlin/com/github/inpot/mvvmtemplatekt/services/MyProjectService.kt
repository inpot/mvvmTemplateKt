package com.github.inpot.mvvmtemplatekt.services

import com.intellij.openapi.project.Project
import com.github.inpot.mvvmtemplatekt.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
