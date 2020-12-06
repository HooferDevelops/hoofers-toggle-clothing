package engineer.iman.clothing.registry;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.render.entity.PlayerModelPart;
import net.minecraft.client.util.InputUtil;

public class Registry implements ModInitializer
{
    boolean enabled = false;

    public void onInitialize() {
        final KeyBinding toggleBind = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.hoof_toggle_clothing.toggle_clothes", InputUtil.Type.KEYSYM, -1, "key.category.hoof_toggle_clothing"));
        ClientTickEvents.END_CLIENT_TICK.register((client -> {

            if (toggleBind.wasPressed()) {

                client.options.setPlayerModelPart(PlayerModelPart.JACKET, this.enabled);
                client.options.setPlayerModelPart(PlayerModelPart.LEFT_SLEEVE, this.enabled);
                client.options.setPlayerModelPart(PlayerModelPart.RIGHT_SLEEVE, this.enabled);
                client.options.setPlayerModelPart(PlayerModelPart.LEFT_PANTS_LEG, this.enabled);
                client.options.setPlayerModelPart(PlayerModelPart.RIGHT_PANTS_LEG, this.enabled);
                this.enabled = !this.enabled;
            }

        }));
    }
}
