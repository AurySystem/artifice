package io.github.vampirestudios.artifice.api.builder.data.worldgen.configured.decorator;

import com.google.gson.JsonObject;
import io.github.vampirestudios.artifice.api.builder.TypedJsonBuilder;
import io.github.vampirestudios.artifice.api.builder.data.worldgen.configured.decorator.config.DecoratorConfigBuilder;
import io.github.vampirestudios.artifice.api.util.Processor;

public class ConfiguredDecoratorBuilder extends TypedJsonBuilder<JsonObject> {

    public ConfiguredDecoratorBuilder() {
        super(new JsonObject(), j->j);
    }

    public ConfiguredDecoratorBuilder name(String decoratorID) {
        this.root.addProperty("type", decoratorID);
        return this;
    }

    public <C extends DecoratorConfigBuilder> ConfiguredDecoratorBuilder config(Processor<C> processor, C instance) {
        with("config", JsonObject::new, jsonObject -> processor.process(instance).buildTo(jsonObject));
        return this;
    }

    public ConfiguredDecoratorBuilder defaultConfig() {
        return this.config(f -> {}, new DecoratorConfigBuilder());
    }
}
