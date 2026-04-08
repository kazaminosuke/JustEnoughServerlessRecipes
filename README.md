# <p align="center"><span style="color:#8000ff;">Just Enough Serverless Recipes</span></p>
<p align="center">
<a href="https://github.com/DraconicVelum/JustEnoughServerlessRecipes/releases/latest"><img alt="Latest release" src="https://img.shields.io/github/release/DraconicVelum/JustEnoughServerlessRecipes.svg?style=popout"></a>
<a href="https://github.com/DraconicVelum/JustEnoughServerlessRecipes/releases"><img alt="Total downloads" src="https://img.shields.io/github/downloads/DraconicVelum/JustEnoughServerlessRecipes/total.svg?style=popout"></a>
<a href="https://github.com/DraconicVelum/JustEnoughServerlessRecipes/blob/main/LICENSE"><img alt="License" src="https://img.shields.io/github/license/DraconicVelum/JustEnoughServerlessRecipes.svg?style=popout"></a>
</p>

<p align="center">
<b><span style="color:#8000ff;">Just Enough Serverless Recipes</span></b> restores JEI recipe browsing on vanilla or lightly modded servers
that do <b>not</b> have JEI installed server-side.
<br>
It injects a synced fallback recipe map on the client so JEI can still display
the full vanilla recipe set, including smithing recipes and armor trims.
</p>

---

## <span style="color:#8000ff;">Description</span>
This mod is for the common case where:

- the player has JEI installed on the client
- the server does not have JEI installed
- JEI normally opens with missing recipe categories or no usable recipe view

`Just Enough Serverless Recipes` fixes that by supplying JEI with a client-side fallback recipe map.

It currently:

- restores vanilla recipe viewing on servers without server-side JEI
- injects the fallback early enough to avoid JEI starting with an empty recipe sync
- supports the full bundled vanilla `26.1.1` recipe set
- includes smithing transform and smithing trim recipes
- uses the integrated server recipe manager automatically in singleplayer
- ships separate Fabric and NeoForge builds

---

## <span style="color:#8000ff;">How It Works</span>
- In singleplayer, the mod reads recipes from the integrated server directly.
- In multiplayer, it injects a bundled vanilla fallback recipe dataset before JEI finishes starting.
- If a server already provides a proper synced recipe map, the mod stays out of the way.

This keeps JEI usable without requiring JEI on the server.

---

## <span style="color:#8000ff;">Requirements</span>
- JEI is required on the client.

## <span style="color:#8000ff;">Compatibility</span>

- Fabric Loader `>=0.17.0`
- Fabric API `>=0.140.3+26.1 <=0.145.4+26.1.1`
- NeoForge `>=26.1.0.8-beta`
- JEI `>=29.2.0.20`
- Fabric: Minecraft `26.1` through `26.1.1`
- NeoForge: Minecraft `26.1` through `26.1.1`

---

## <span style="color:#8000ff;">Installation</span>
1. Choose the matching `Fabric` or `NeoForge` build.
2. Install the required loader for that build.
3. For Fabric, also install Fabric API.
4. Install the matching JEI build on the client.
5. Install `Just Enough Serverless Recipes` on the client.
6. Launch the game and join a server without JEI installed server-side.

---

## <span style="color:#8000ff;">Notes</span>
- This is a client-side mod.
- The server does not need to install this mod.
- The server does not need to install JEI.
- The player still needs JEI installed locally, because this mod extends JEI rather than replacing it.

---

## <span style="color:#8000ff;">Licensing</span>
Licensed under the [GPLv3.0](https://github.com/DraconicVelum/JustEnoughServerlessRecipes/blob/main/LICENSE).
