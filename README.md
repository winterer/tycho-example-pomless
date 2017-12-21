# tycho-example-pomless

This example is a simple multi-module POM-less tycho project with one plugin, one fragment (containing the plugin) and one update site based on this feature.

Releasing this maven/tycho project with the [unleash-maven-plugin](https://github.com/shillner/unleash-maven-plugin) (version 2.7.4), goal `unleash:perform-tycho` fails with the error:

```
...
[INFO] 21:20:27,634  Removing artifact-spy-plugin from build configuration.
[INFO] 21:20:27,650  Checking remote SCM repository for changes. Initial revision was 91fe6310c121224d42225d20c2ab12eaff6a0816
[INFO] 21:20:27,650  Tagging local and remote SCM repositories.
[INFO] 21:20:27,665  Git - Searching for Git tag '0.0.1'
[INFO] 21:20:28,543  Git - Tagging local repository with '0.0.1'
[INFO] 21:20:28,543  Git - Committing local changes.
[INFO] 21:20:28,684  Git - Commit finished successfully. New revision is: e87c22f36dd784d4f3635891d2b0d23153efc637
[INFO] 21:20:32,515  Git - Tag creation finished successfully. New revision is: 91fe6310c121224d42225d20c2ab12eaff6a0816
[INFO] 21:20:32,515  Detecting all release artifacts that have been produced during the release build for later installation and deployment.
[ERROR] An exception was caught while processing the workflow step with id 'detectReleaseArtifacts'.
org.apache.maven.plugin.MojoExecutionException: Could not determine project release artifacts. Project: at.winterer.tycho:plugin1:0.0.1
    at com.itemis.maven.plugins.unleash.steps.actions.DetectReleaseArtifacts.execute (DetectReleaseArtifacts.java:86)
    at com.itemis.maven.plugins.cdi.internal.util.workflow.WorkflowExecutor.executeSequentialWorkflowStep (WorkflowExecutor.java:157)
    at com.itemis.maven.plugins.cdi.internal.util.workflow.WorkflowExecutor.execute (WorkflowExecutor.java:119)
    at com.itemis.maven.plugins.cdi.AbstractCDIMojo.execute (AbstractCDIMojo.java:209)
    at org.apache.maven.plugin.DefaultBuildPluginManager.executeMojo (DefaultBuildPluginManager.java:134)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:208)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:154)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:146)
    at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject (LifecycleModuleBuilder.java:117)
    at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject (LifecycleModuleBuilder.java:81)
    at org.apache.maven.lifecycle.internal.builder.singlethreaded.SingleThreadedBuilder.build (SingleThreadedBuilder.java:51)
    at org.apache.maven.lifecycle.internal.LifecycleStarter.execute (LifecycleStarter.java:128)
    at org.apache.maven.DefaultMaven.doExecute (DefaultMaven.java:309)
    at org.apache.maven.DefaultMaven.doExecute (DefaultMaven.java:194)
    at org.apache.maven.DefaultMaven.execute (DefaultMaven.java:107)
    at org.apache.maven.cli.MavenCli.execute (MavenCli.java:955)
    at org.apache.maven.cli.MavenCli.doMain (MavenCli.java:290)
    at org.apache.maven.cli.MavenCli.main (MavenCli.java:194)
    at sun.reflect.NativeMethodAccessorImpl.invoke0 (Native Method)
    at sun.reflect.NativeMethodAccessorImpl.invoke (NativeMethodAccessorImpl.java:62)
    at sun.reflect.DelegatingMethodAccessorImpl.invoke (DelegatingMethodAccessorImpl.java:43)
    at java.lang.reflect.Method.invoke (Method.java:498)
    at org.codehaus.plexus.classworlds.launcher.Launcher.launchEnhanced (Launcher.java:289)
    at org.codehaus.plexus.classworlds.launcher.Launcher.launch (Launcher.java:229)
    at org.codehaus.plexus.classworlds.launcher.Launcher.mainWithExitCode (Launcher.java:415)
    at org.codehaus.plexus.classworlds.launcher.Launcher.main (Launcher.java:356)
Caused by: java.io.FileNotFoundException: C:\projects\github\winterer\https\tycho-example-pomless\plugin1\.polyglot.build.properties (The system cannot find the file specified)
    at java.io.FileInputStream.open0 (Native Method)
    at java.io.FileInputStream.open (FileInputStream.java:195)
    at java.io.FileInputStream.<init> (FileInputStream.java:138)
    at com.google.common.io.Files$FileByteSource.openStream (Files.java:128)
    at com.google.common.io.Files$FileByteSource.openStream (Files.java:118)
    at com.google.common.io.ByteSource.copyTo (ByteSource.java:267)
    at com.google.common.io.Files.copy (Files.java:325)
    at com.itemis.maven.plugins.unleash.steps.actions.DetectReleaseArtifacts.execute (DetectReleaseArtifacts.java:76)
    at com.itemis.maven.plugins.cdi.internal.util.workflow.WorkflowExecutor.executeSequentialWorkflowStep (WorkflowExecutor.java:157)
    at com.itemis.maven.plugins.cdi.internal.util.workflow.WorkflowExecutor.execute (WorkflowExecutor.java:119)
    at com.itemis.maven.plugins.cdi.AbstractCDIMojo.execute (AbstractCDIMojo.java:209)
    at org.apache.maven.plugin.DefaultBuildPluginManager.executeMojo (DefaultBuildPluginManager.java:134)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:208)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:154)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:146)
    at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject (LifecycleModuleBuilder.java:117)
    at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject (LifecycleModuleBuilder.java:81)
    at org.apache.maven.lifecycle.internal.builder.singlethreaded.SingleThreadedBuilder.build (SingleThreadedBuilder.java:51)
    at org.apache.maven.lifecycle.internal.LifecycleStarter.execute (LifecycleStarter.java:128)
    at org.apache.maven.DefaultMaven.doExecute (DefaultMaven.java:309)
    at org.apache.maven.DefaultMaven.doExecute (DefaultMaven.java:194)
    at org.apache.maven.DefaultMaven.execute (DefaultMaven.java:107)
    at org.apache.maven.cli.MavenCli.execute (MavenCli.java:955)
    at org.apache.maven.cli.MavenCli.doMain (MavenCli.java:290)
    at org.apache.maven.cli.MavenCli.main (MavenCli.java:194)
    at sun.reflect.NativeMethodAccessorImpl.invoke0 (Native Method)
    at sun.reflect.NativeMethodAccessorImpl.invoke (NativeMethodAccessorImpl.java:62)
    at sun.reflect.DelegatingMethodAccessorImpl.invoke (DelegatingMethodAccessorImpl.java:43)
    at java.lang.reflect.Method.invoke (Method.java:498)
    at org.codehaus.plexus.classworlds.launcher.Launcher.launchEnhanced (Launcher.java:289)
    at org.codehaus.plexus.classworlds.launcher.Launcher.launch (Launcher.java:229)
    at org.codehaus.plexus.classworlds.launcher.Launcher.mainWithExitCode (Launcher.java:415)
    at org.codehaus.plexus.classworlds.launcher.Launcher.main (Launcher.java:356)
[INFO] Rolling back after execution errors - please find the error messages and stack traces above.
[INFO] 21:20:32,547  Rollback of SCM tag creation and POM modifications due to a processing exception.
```

However, the branch [with-pom](https://github.com/winterer/tycho-example-pomless/tree/with-pom) shows that the entire project can be released without error when all artifacts have valid POMs.

Exact command used to build the project:

`mvn clean unleash:perform-tycho -Dworkflow=unleash-workflow -Dunleash.scmUsername=<username> -Dunleash.scmPassword=<password>`

(Note: The custom workflow just skips the last step - deployment of the artifact.)
