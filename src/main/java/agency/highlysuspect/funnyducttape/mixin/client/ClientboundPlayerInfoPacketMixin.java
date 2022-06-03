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

@Mixin(ClientboundPlayerInfoPacket.class)
public class ClientboundPlayerInfoPacketMixin {
	/**
	 * @author quat
	 * @reason Your mom
	 */
	@Overwrite
	static @Nullable Component readDisplayName(FriendlyByteBuf buf) {
		FunnyDuctTape.LOGGER.info("Hello from readDisplayName");
		if(!buf.readBoolean()) return null;
		
		FunnyDuctTape.LOGGER.info("Has display name. Entering trycatch");
		
		try {
			FunnyDuctTape.LOGGER.info("Current stacktrace (not an error, yet):");
			new Exception().printStackTrace();
			
			FunnyDuctTape.LOGGER.info("Calling readUtf:");
			String s = buf.readUtf(262144);
			FunnyDuctTape.LOGGER.info("Got Display Name JSON as string: length {}, text {}", s.length(), s);
			FunnyDuctTape.LOGGER.info("Trying to parse");
			
			Component component = Component.Serializer.fromJson(s);
			FunnyDuctTape.LOGGER.info("Successfully parsed");
			return component;
		} catch (Exception e) {
			e.printStackTrace();
			return new TextComponent("[FunnyDuctTape] Crash in ClientboundPlayerInfoPacket#readComponent. See log").withStyle(ChatFormatting.RED);
		}
	}
}
