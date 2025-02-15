package io.github.vampirestudios.artifice.api.builder.data.worldgen.configured.feature.config;

import com.google.gson.JsonObject;
import io.github.vampirestudios.artifice.api.builder.data.worldgen.UniformIntDistributionBuilder;
import io.github.vampirestudios.artifice.api.util.Processor;

public class BasaltColumnsFeatureConfigBuilder extends FeatureConfigBuilder {

    public BasaltColumnsFeatureConfigBuilder() {
        super();
    }

    public BasaltColumnsFeatureConfigBuilder reach(Processor<UniformIntDistributionBuilder> processor) {
        with("reach", JsonObject::new, jsonObject -> processor.process(new UniformIntDistributionBuilder()).buildTo(jsonObject));
        return this;
    }

    public BasaltColumnsFeatureConfigBuilder height(Processor<UniformIntDistributionBuilder> processor) {
        with("height", JsonObject::new, jsonObject -> processor.process(new UniformIntDistributionBuilder()).buildTo(jsonObject));
        return this;
    }
}
