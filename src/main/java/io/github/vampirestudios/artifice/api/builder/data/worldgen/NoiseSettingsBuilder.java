package io.github.vampirestudios.artifice.api.builder.data.worldgen;

import com.google.gson.JsonObject;
import io.github.vampirestudios.artifice.api.builder.TypedJsonBuilder;
import io.github.vampirestudios.artifice.api.builder.data.StateDataBuilder;
import io.github.vampirestudios.artifice.api.builder.data.dimension.NoiseConfigBuilder;
import io.github.vampirestudios.artifice.api.builder.data.dimension.StructureManagerBuilder;
import io.github.vampirestudios.artifice.api.resource.JsonResource;
import io.github.vampirestudios.artifice.api.util.Processor;

public class NoiseSettingsBuilder extends TypedJsonBuilder<JsonResource<JsonObject>> {
    public NoiseSettingsBuilder() {
        super(new JsonObject(), JsonResource::new);
    }

    /**
     * Set the bedrock roof position. deprecated?
     * @param bedrockRoofPosition
     * @return
     */
    public NoiseSettingsBuilder bedrockRoofPosition(int bedrockRoofPosition) {
        this.root.addProperty("bedrock_roof_position", bedrockRoofPosition);
        return this;
    }

    /**
     * Set the bedrock floor position. deprecated?
     * @param bedrockFloorPosition
     * @return
     */
    public NoiseSettingsBuilder bedrockFloorPosition(int bedrockFloorPosition) {
        this.root.addProperty("bedrock_floor_position", bedrockFloorPosition);
        return this;
    }

    /**
     * Set the sea level.
     * @param seaLevel
     * @return
     */
    public NoiseSettingsBuilder seaLevel(int seaLevel) {
        this.root.addProperty("sea_level", seaLevel);
        return this;
    }

    /**
     * Build noise config.
     */
    public NoiseSettingsBuilder noiseConfig(Processor<NoiseConfigBuilder> noiseConfigBuilder) {
        with("noise", JsonObject::new, jsonObject -> noiseConfigBuilder.process(new NoiseConfigBuilder()).buildTo(jsonObject));
        return this;
    }

    public NoiseSettingsBuilder disableMobGeneration(boolean disableMobGeneration) {
        this.root.addProperty("disable_mob_generation", disableMobGeneration);
        return this;
    }

    public NoiseSettingsBuilder aquifersEnabled(boolean aquifersEnabled) {
        this.root.addProperty("aquifers_enabled", aquifersEnabled);
        return this;
    }

    public NoiseSettingsBuilder noiseCavesEnabled(boolean noiseCavesEnabled) {
        this.root.addProperty("noise_caves_enabled", noiseCavesEnabled);
        return this;
    }

    public NoiseSettingsBuilder noodleCavesEnabled(boolean noodleCavesEnabled) {
        this.root.addProperty("noodle_caves_enabled", noodleCavesEnabled);
        return this;
    }

    public NoiseSettingsBuilder oreVeinsEnabled(boolean oreVeinsEnabled) {
        this.root.addProperty("ore_veins_enabled", oreVeinsEnabled);
        return this;
    }

    public NoiseSettingsBuilder legacyRandomSource(boolean legacyRandomSource) {
        this.root.addProperty("legacy_random_source", legacyRandomSource);
        return this;
    }

    @Deprecated
    public NoiseSettingsBuilder grimstoneEnabled(boolean grimstoneEnabled) {
        this.root.addProperty("grimstone_enabled", grimstoneEnabled);
        return this;
    }

    /**
     * Set a block state.
     * @param id
     * @param blockStateBuilderProcessor
     * @return
     */
    public NoiseSettingsBuilder setBlockState(String id, Processor<StateDataBuilder> blockStateBuilderProcessor) {
        with(id, JsonObject::new, jsonObject -> blockStateBuilderProcessor.process(new StateDataBuilder()).buildTo(jsonObject));
        return this;
    }

    /**
     * Build default block.
     * @param blockStateBuilderProcessor
     * @return
     */
    public NoiseSettingsBuilder defaultBlock(Processor<StateDataBuilder> blockStateBuilderProcessor) {
        return this.setBlockState("default_block", blockStateBuilderProcessor);
    }

    /**
     * Build default fluid.
     * @param blockStateBuilderProcessor
     * @return
     */
    public NoiseSettingsBuilder defaultFluid(Processor<StateDataBuilder> blockStateBuilderProcessor) {
        return this.setBlockState("default_fluid", blockStateBuilderProcessor);
    }

    /**
     * Build structure manager.
     * @param structureManagerBuilder
     * @return
     */
    public NoiseSettingsBuilder structureManager(Processor<StructureManagerBuilder> structureManagerBuilder) {
        with("structures", JsonObject::new, jsonObject -> structureManagerBuilder.process(new StructureManagerBuilder()).buildTo(jsonObject));
        return this;
    }

    /**
     * Build surface rules.
     * @param surfaceRulesBuilder
     * @return this
     */
    public NoiseSettingsBuilder surfaceRules(Processor<SurfaceRulesBuilder> surfaceRulesBuilder) {
        with("surface_rule", JsonObject::new, jsonObject -> surfaceRulesBuilder.process(new SurfaceRulesBuilder()).buildTo(jsonObject));
        return this;
    }
}
