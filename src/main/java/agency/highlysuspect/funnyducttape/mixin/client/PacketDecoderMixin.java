package agency.highlysuspect.funnyducttape.mixin.client;

import agency.highlysuspect.funnyducttape.FunnyDuctTape;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.PacketDecoder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PacketDecoder.class)
public class PacketDecoderMixin {
//	@Redirect(
//		method = "decode",
//		at = @At(
//			value = "INVOKE",
//			target = "Lnet/minecraft/network/FriendlyByteBuf;readableBytes()I",
//			ordinal = 1
//		)
//	)
//	private int whenYou(FriendlyByteBuf instance) {
//		int realReadableBytes = instance.readableBytes();
//		if(realReadableBytes > 0) {
//			FunnyDuctTape.LOGGER.info("ReadableBytes > 0 ({}) after reading a packet in PacketDecoder!!!!!!! this is a sign of a HUGE PROBLEM!!!!!!!! Trying to overlook it in order to salvage what's left of this game connection", realReadableBytes);
//		}
//		
//		return 0;
//	}
}
