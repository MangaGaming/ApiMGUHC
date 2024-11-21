package com.mguhc.populator;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;

public class OrePopulator extends BlockPopulator {
	
	private Random random = new Random();
        @Override
        public void populate(World world, Random random, Chunk chunk) {
            // Pour chaque bloc de minerai, on double la quantité générée
            generateOres(world, chunk, Material.DIAMOND_ORE, 2); // Double les diamants
            generateOres(world, chunk, Material.GOLD_ORE, 2); // Double l'or
        }

        private void generateOres(World world, Chunk chunk, Material oreType, int multiplier) {
            for (int i = 0; i < 10 * multiplier; i++) { // Par exemple, 10 fois la quantité normale
				int x = chunk.getX() * 16 + random.nextInt(16);
                int z = chunk.getZ() * 16 + random.nextInt(16);
                int y = random.nextInt(64); // Hauteur où les minerais peuvent apparaître (0-63)

                Block block = chunk.getBlock(x, y, z);
                if (block.getType() == Material.STONE) { // Vérifiez si le bloc est de la pierre
                    block.setType(oreType); // Remplacez-le par le minerai
                }
            }
        }
    }