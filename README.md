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

---

## <span style="color:#8000ff;">How It Works</span>
- In singleplayer, the mod reads recipes from the integrated server directly.
- In multiplayer, it injects a bundled vanilla fallback recipe dataset before JEI finishes starting.
- If a server already provides a proper synced recipe map, the mod stays out of the way.

This keeps JEI usable without requiring JEI on the server.

---

## <span style="color:#8000ff;">Requirements</span>
- [Fabric Loader](https://fabricmc.net/use/installer/)
- [Fabric API](https://modrinth.com/mod/fabric-api)
- [Just Enough Items (JEI) for Fabric](https://modrinth.com/mod/jei)

JEI is required on the client.

Supported JEI range:

- `>=29.2.0 <30.0.0`

---

## <span style="color:#8000ff;">Installation</span>
1. Install Fabric Loader.
2. Install Fabric API.
3. Install JEI on the client.
4. Install `Just Enough Serverless Recipes` on the client.
5. Launch the game and join a server without JEI installed server-side.

---

## <span style="color:#8000ff;">Notes</span>
- This is a client-side mod.
- The server does not need to install this mod.
- The server does not need to install JEI.
- The player still needs JEI installed locally, because this mod extends JEI rather than replacing it.

---

## <span style="color:#8000ff;">Compatibility</span>
Designed for:

- Minecraft `26.1`
- Fabric Loader `0.18.5+`
- JEI Fabric `29.x`

If JEI changes its internal sync or startup behavior in a future major version, the supported JEI range should be updated alongside the mod.

---

## <span style="color:#8000ff;">Licensing</span>
Licensed under the [GPLv3.0](https://github.com/DraconicVelum/JustEnoughServerlessRecipes/blob/main/LICENSE).
