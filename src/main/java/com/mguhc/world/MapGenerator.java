package com.mguhc.world;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.generator.ChunkGenerator;

public class MapGenerator {

    public World createWorld(String worldName) {
        // Créer un nouveau monde avec un générateur personnalisé
        WorldCreator creator = new WorldCreator(worldName);
        creator.environment(World.Environment.NORMAL);
        creator.type(WorldType.NORMAL); // Ou un autre type selon vos besoins
        creator.generator(new CustomChunkGenerator()); // Utilisez votre propre générateur de chunks

        // Charger le monde
        World world = Bukkit.createWorld(creator);
        return world;
    }

    private class CustomChunkGenerator extends ChunkGenerator {
        @Override
        public ChunkData generateChunkData(World world, Random random, int x, int z, BiomeGrid biome) {
            ChunkData chunkData = createChunkData(world);

            // Exemple de génération de terrain
            for (int y = 0; y < 256; y++) {
                for (int xOffset = 0; xOffset < 16; xOffset++) {
                    for (int zOffset = 0; zOffset < 16; zOffset++) {
                        // Remplir le chunk avec des blocs (exemple simple)
                        if (y == 0) {
                            chunkData.setBlock(xOffset, y, zOffset, Material.BEDROCK);
                        } else if (y < 60) {
                            chunkData.setBlock(xOffset, y, zOffset, Material.STONE);
                        } else {
                            chunkData.setBlock(xOffset, y, zOffset, Material.GRASS);
                        }
                    }
                }
            }

            return chunkData;
        }
    }
}
