package com.tuppymsm.exoticnature.world.biome;

import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.sounds.Music;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;

import javax.annotation.Nullable;

public class ModNetherBiomes {
    @Nullable
    private static final Music NORMAL_MUSIC = null;

    protected static int calculateSkyColor(float color) {
        float $$1 = color / 3.0F;
        $$1 = Mth.clamp($$1, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - $$1 * 0.05F, 0.5F + $$1 * 0.1F, 1.0F);
    }
    private static Biome biome(Biome.Precipitation precipitation, Biome.BiomeCategory category,
                               float temperature, float downfall, MobSpawnSettings.Builder spawnBuilder,
                               BiomeGenerationSettings.Builder biomeBuilder, @Nullable Music music) {
        return biome(precipitation, category, temperature, downfall, 4159204, 329011, spawnBuilder, biomeBuilder, music);
    }

    private static Biome biome(Biome.Precipitation precipitation, Biome.BiomeCategory category, float temperature, float downfall,
                               int waterColor, int waterFogColor, MobSpawnSettings.Builder spawnBuilder,
                               BiomeGenerationSettings.Builder biomeBuilder, @Nullable Music music) {
        return (new Biome.BiomeBuilder()).precipitation(precipitation).biomeCategory(category).temperature(temperature).downfall(downfall).
                specialEffects((new BiomeSpecialEffects.Builder()).waterColor(waterColor).
                        waterFogColor(waterFogColor).fogColor(12638463).skyColor(calculateSkyColor(temperature)).
                        ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(music).build()).
                mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }

    private static void globalNetherGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addAncientDebris(builder);
        BiomeDefaultFeatures.addNetherDefaultOres(builder);
    }
}
