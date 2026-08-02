# Always Sprint

A Fabric client-side mod that automatically enables sprinting while the player moves forward. It does not add a keybind or bypass vanilla sprint restrictions.

## Supported Minecraft versions

| Minecraft version | Project directory |
| --- | --- |
| 1.21.11 | `1.21.11` |
| 26.1 | `26.1` |
| 26.2 | `26.2` |

## Build

Each supported version is an independent Gradle project. From the relevant directory, run:

```powershell
.\gradlew.bat build
```

The remapped mod jar will be written to `build/libs/alwayssprint-1.0.0.jar`.

## Installation

Install the matching Fabric Loader and Fabric API for your Minecraft version, then place the built jar in your Minecraft `mods` folder.

## License

This project is licensed under the MIT License. See [LICENSE](LICENSE).
