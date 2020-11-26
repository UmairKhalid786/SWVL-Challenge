# SWVL Code challange
# <img src="https://swvl.com/assets/img/swvl-logo.svg" height=150 alt="SWVL Code challange" />

![SWVL Code challange v1.0.0 badge][changelog-badge] ![Version 1.0.0 Badge][version-badge]

# SWVL Code challange (Mobile) Application
=====================================================

This repository generates [app.](https://play.google.com/store/apps/details?id=com.app.swvl&hl=en)<br />

Prerequisites
--------------

 - Android SDK v24
 - Latest Android Build Tools
 - Android Support Repository


Getting started
---------------

This sample uses the Gradle build system.

 - Download the samples by cloning this repository or downloading an archived
  snapshot. (See the options at the top of the page.)
 - In Android Studio, create a new project and choose the "Import non-Android Studio project" or
  "Import Project" option.
 - Select the `swvl` directory that you downloaded with this repository.
 - If prompted for a gradle configuration, accept the default settings.
  Alternatively use the "gradlew build" command to build the project directly.

 - We follow standard Git flow to code management for details please visit [nvie.com](https://nvie.com/posts/a-successful-git-branching-model/)


Architecture
---------------
I used MVVM with repository pattren using Hilt 


Programming Languages
---------------
Kotlin


Whats missing ?  
---------------
There was some issues with Flickr images, URL was perfectly ok when playing outside app. Unfortunatly I didnt had enough time to debug it.Will fix it soon :)


Tests  
---------------
I wrote test for ViewModels only becasue they are considered to be the toughest 

[changelog-badge]: https://img.shields.io/badge/SWVL%20Challenge%20v1.0.0-%23E05735
[license]: ./LICENSE
[rbenv]: https://github.com/rbenv/rbenv
[ruby-version]: .ruby-version
[source]: source/
[pull-request]: https://help.github.com/articles/creating-a-pull-request/
[fork]: https://help.github.com/articles/fork-a-repo/
[version-badge]: https://img.shields.io/badge/version-1.0.0-blue.svg
[license-badge]: https://img.shields.io/badge/license-MIT-blue.svg

