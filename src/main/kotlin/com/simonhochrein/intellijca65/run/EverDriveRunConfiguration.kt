package com.simonhochrein.intellijca65.run

import com.intellij.execution.ExecutionResult
import com.intellij.execution.Executor
import com.intellij.execution.configurations.*
import com.intellij.execution.filters.TextConsoleBuilderImpl
import com.intellij.execution.process.ProcessHandler
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.execution.runners.ProgramRunner
import com.intellij.execution.ui.ConsoleView
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project
import java.io.OutputStream

class EverDriveRunConfiguration(
    project: Project,
    factory: EverDriveConfigurationFactory,
    name: String
) : RunConfigurationBase<RunConfigurationOptions>(project, factory, name) {

    var scriptName: String?
        get() = options.scriptName
        set(value) {
            options.scriptName = value
        }

    override fun getOptions(): EverDriveRunConfigurationOptions {
        return super.getOptions() as EverDriveRunConfigurationOptions
    }

    override fun getState(executor: Executor, environment: ExecutionEnvironment): RunProfileState {
//        return object : CommandLineState(environment) {
//            override fun startProcess(): ProcessHandler {
//                val commandLine = GeneralCommandLine(options.scriptName)
//                val processHandler = ProcessHandlerFactory.getInstance().createColoredProcessHandler(commandLine)
//                ProcessTerminatedListener.attach(processHandler)
//                return processHandler
//            }
//        }
        return EverDriveRunProfileState(environment, this)
    }

    override fun getConfigurationEditor(): SettingsEditor<out RunConfiguration> {
        return EverDriveSettingsEditor()
    }

    class EverDriveRunProfileState(private val env: ExecutionEnvironment, private val myConfiguration: EverDriveRunConfiguration): CommandLineState(env) {
        override fun execute(executor: Executor, runner: ProgramRunner<*>): ExecutionResult {
            val consoleBuilder = object : TextConsoleBuilderImpl(myConfiguration.project) {
                override fun getConsole(): ConsoleView {
                    return super.getConsole()
                }
            }
            setConsoleBuilder(consoleBuilder)
            return super.execute(executor, runner)
        }
        override fun createActions(console: ConsoleView?, processHandler: ProcessHandler?): Array<AnAction> {
            return arrayOf(EverDriveRunProfileAction())
        }

        override fun startProcess(): ProcessHandler {
            return object : ProcessHandler() {
                override fun destroyProcessImpl() {

                }

                override fun detachProcessImpl() {

                }

                override fun detachIsDefault(): Boolean {
                    return false
                }

                override fun getProcessInput(): OutputStream? {
                   return null
                }

            }
        }

    }

}
