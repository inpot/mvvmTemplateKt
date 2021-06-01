package other.mvvm.activity.src


fun mvvmRepo(
    moduleName: String,
    packageName: String,
) = """
package ${(packageName)}.model

import app.base.mvvm.repository.BaseRepository
import javax.inject.Inject
import ${(packageName)}.di.${moduleName}Contract

class ${moduleName}Rep @Inject constructor() : BaseRepository(), ${moduleName}Contract.Repository{
//TODO add your fun here


}

"""
