package io.github.vampirestudios.artifice.api.builder.data.worldgen.configured;

import com.google.gson.JsonObject;
import io.github.vampirestudios.artifice.api.builder.TypedJsonBuilder;
import io.github.vampirestudios.artifice.api.builder.data.StateDataBuilder;
import io.github.vampirestudios.artifice.api.resource.JsonResource;
import io.github.vampirestudios.artifice.api.util.Processor;

public class ConfiguredSurfaceBuilder extends TypedJsonBuilder<JsonResource<JsonObject>> {
    public ConfiguredSurfaceBuilder() {
        super(new JsonObject(), JsonResource::new);
        this.root.add("config", new JsonObject());
    }

    /**
     * Set a block state.
     * @param id
     * @param blockStateBuilderProcessor
     * @return
     */
    private ConfiguredSurfaceBuilder setBlockState(String id, Processor<StateDataBuilder> blockStateBuilderProcessor) {
        with(this.root.getAsJsonObject("config"),id, JsonObject::new, jsonObject -> blockStateBuilderProcessor.process(new StateDataBuilder()).buildTo(jsonObject));
        return this;
    }

    public ConfiguredSurfaceBuilder topMaterial(Processor<StateDataBuilder> blockStateBuilderProcessor) {
        return this.setBlockState("top_material", blockStateBuilderProcessor);
    }

    public ConfiguredSurfaceBuilder underMaterial(Processor<StateDataBuilder> blockStateBuilderProcessor) {
        return this.setBlockState("under_material", blockStateBuilderProcessor);
    }

    public ConfiguredSurfaceBuilder underwaterMaterial(Processor<StateDataBuilder> blockStateBuilderProcessor) {
        return this.setBlockState("underwater_material", blockStateBuilderProcessor);
    }

    public ConfiguredSurfaceBuilder surfaceBuilderID(String id) {
        this.root.addProperty("type", id);
        return this;
    }

}
