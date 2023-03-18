# Kotlin/Native and Multiplatform Workshop

**Javaland 2023, Mittwoch 22.03.2023 | 14:30 - 17:30 | Community Room**

Community activity workshop

Michal Harakal, Alexander von Below

With the advancement of digitization, the demand for human-machine interface applications in various industrial sectors
is also growing. They should not only be safe, reliable and slim – they should also be modern, good-looking and
networked. In this hands-on workshop, we'll build a simple JVM desktop app that communicates with a real device and look
at the strengths of Kotlin and Kotlin Multiplatform. We will learn how to easily support multiple platforms (desktop and
mobile, especially with a focus on Apple operating systems) without compromising, how Kotlin and the JVM work well
together and how declarative UI frameworks, such as Jetpack Compose and Swift UI, are the kind and changing the way
responsive user interfaces are designed today.

## Learning goals

* How to set up a multiplatform project
* How to use Kotlin Multiplatform to build a desktop application
* How to use Kotlin Multiplatform to build a mobile application
* How to display data from a real device with declarative UI frameworks(Jetpack Compose and Swift UI)

## Setup the environment

See detailed instructions in the [setup](setup.md) section.

## Codelabs

Code labs are split into separated branches. Consequent branches are based on previous ones. If you have any problems or
just want to skip over to the next step, simply check the next branch. Every clean checkout branch should build from
command line.

!!! note
Because of switching between the branches, build configurations and dependencies may be changed. Sometimes it is
necessary to clean the project and/or restart the IDE. If this does not help, try to delete the `.idea` and `.gradle`
folder and restart the IDE.

Particular learnigs steps are split into separated branches.

* [Setup](setup.md) – Setting up the project
* [Part 1](codelab-1.md) – Create your first app that works both on Android and iOS with the IDE
* [Part 2](codelab-2.md) – Add a desktop app to your project
* [Part 3](codelab-3.md) – Add business logic to your project
* [Part 4](codelab-4.md) – Show me the data, adding views to your project
* [Part 4](codelab-5.md) – Add a real device to your project

