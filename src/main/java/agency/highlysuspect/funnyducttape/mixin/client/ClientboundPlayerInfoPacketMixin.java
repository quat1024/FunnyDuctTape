package agency.highlysuspect.funnyducttape.mixin.client;

import agency.highlysuspect.funnyducttape.FunnyDuctTape;
import net.minecraft.ChatFormatting;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.protocol.game.ClientboundPlayerInfoPacket;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ClientboundPlayerInfoPacket.class)
public class ClientboundPlayerInfoPacketMixin {
	static {
		for(int i = 0; i < 20; i++) {
			FunnyDuctTape.LOGGER.info("Conspicuous Log Spam that shows ClientBoundPlayerInfoPacketMixin succeeded !!!!!!!!!!!!!!!!!!! Ok!!!!!!!!!!");
		}
	}
	
	@Redirect(
		method = "<init>(Lnet/minecraft/network/FriendlyByteBuf;)V",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/network/FriendlyByteBuf;readEnum(Ljava/lang/Class;)Ljava/lang/Enum;"
		)
	)
	private <T extends Enum<T>> T asdahjdjdkj(FriendlyByteBuf friendlyByteBuf, Class<T> class_) {
		int oldIndex = friendlyByteBuf.readerIndex();
		
		int len = friendlyByteBuf.readableBytes();
		FunnyDuctTape.LOGGER.info("Got ClientboundPlayerInfoPacket length {}. Attempting to hex dump idk im not good at bytebufs", len);
		StringBuilder hex = new StringBuilder();
		for(int i = 0; i < len; i++) {
			hex.append(String.format("%02x", friendlyByteBuf.readByte()));
		}
		FunnyDuctTape.LOGGER.info("Hexdump: {}", hex);
		
		friendlyByteBuf.readerIndex(oldIndex);
		
		//original method
		return friendlyByteBuf.readEnum(class_);
	}
	
	/**
	 * @author quat
	 * @reason Your mom
	 */
	@Overwrite
	public static @Nullable Component readDisplayName(FriendlyByteBuf buf) {
		FunnyDuctTape.LOGGER.info("Hello from readDisplayName");
		if(!buf.readBoolean()) return null;
		
		try {
			FunnyDuctTape.LOGGER.info("Has display name. Calling readUtf:");
			String s = buf.readUtf(262144);
			FunnyDuctTape.LOGGER.info("Got Display Name JSON as string: length {}, text {}", s.length(), s);
			FunnyDuctTape.LOGGER.info("Trying to parse");
			
			Component component = Component.Serializer.fromJson(s);
			FunnyDuctTape.LOGGER.info("Successfully parsed");
			return component;
		} catch (Exception e) {
			FunnyDuctTape.LOGGER.error("CRASH!!!!!!!", e);
			
			FunnyDuctTape.LOGGER.error("Trying to salvage FriendlyByteBuf");
			buf.readerIndex(buf.readableBytes() - 1);
			
			return new TextComponent("[FunnyDuctTape] readComponent crashed. See log").withStyle(ChatFormatting.RED);
		}
	}
}
