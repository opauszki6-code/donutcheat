# Best Client (starter project)

Fabric client mod scaffold for Minecraft Java 1.21.11.

## Included
- Client mod entrypoint and Right Shift menu key
- Best Client screen with module toggle buttons
- Module registry for the requested feature names

## Important
This is a **starter scaffold**, not a finished cheat client. The buttons currently toggle UI state only; ESP rendering, freecam camera control, inventory automation, and PvP macros still need separate implementation and testing. Use only where permitted by the server rules.

## Build
Requires JDK 21 and Gradle. Open the folder in IntelliJ IDEA with the Minecraft Development plugin, let Gradle sync, then run `gradle build`. The remapped mod jar should be in `build/libs/`.

Fabric API and Fabric Loader must match Minecraft 1.21.11. Current values are listed in `gradle.properties`; update them to the latest compatible versions if Gradle reports that a version is unavailable.

## GitHub Actions build

1. Create a GitHub repository and upload/push the contents of this folder.
2. Push to `main` or `master` (or open the **Actions** tab and run **Best Client Build** manually).
3. Open the completed workflow run, then download the `Best-Client-Minecraft-1.21.11` artifact from **Artifacts**.

The workflow uses Java 21 and Gradle 8.14 and uploads the built JAR from `build/libs/`.
