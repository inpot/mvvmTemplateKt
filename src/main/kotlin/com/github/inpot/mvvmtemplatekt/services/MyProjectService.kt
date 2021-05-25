package com.github.inpot.mvvmtemplatekt.services

import com.github.inpot.mvvmtemplatekt.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
