package ca.rttv.no.more.microsoft.mixin;

import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MinecraftClient.class)
abstract class MinecraftClientMixin {
    @Inject(method = "isMultiplayerEnabled()Z", at = @At("HEAD"), cancellable = true)
    private void isMultiplayerEnabled(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(true);
    }

    @Inject(method = "getChatRestriction", at = @At("HEAD"), cancellable = true)
    private void getChatRestriction(CallbackInfoReturnable<MinecraftClient.ChatRestriction> cir) {
        cir.setReturnValue(MinecraftClient.ChatRestriction.ENABLED);
    }
}
