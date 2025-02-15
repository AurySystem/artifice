package io.github.vampirestudios.artifice.api.builder.data.worldgen.configured.decorator.config;

import com.google.gson.JsonObject;
import io.github.vampirestudios.artifice.api.builder.data.worldgen.UniformIntDistributionBuilder;
import io.github.vampirestudios.artifice.api.util.Processor;

public class CountConfigBuilder extends DecoratorConfigBuilder {
    public CountConfigBuilder() {
        super();
    }

    public CountConfigBuilder count(int count) {
        this.root.addProperty("count", count);
        return this;
    }

    public CountConfigBuilder count(Processor<UniformIntDistributionBuilder> processor) {
        with("count", JsonObject::new, jsonObject -> processor.process(new UniformIntDistributionBuilder()).buildTo(jsonObject));
        return this;
    }
}
