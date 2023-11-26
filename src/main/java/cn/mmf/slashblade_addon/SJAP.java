package cn.mmf.slashblade_addon;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Tags.MOD_ID,
		name = SJAP.NAME,
		version = Tags.VERSION,
		acceptedMinecraftVersions = "1.12.2"
		// TODO: Re-add dependencies
		// dependencies = "required:mixinbooter@[4.2,);after:jei@[4.15.0,);after:crafttweaker"
		)
public class SJAP {
	public static final String MOD_ID = Tags.MOD_ID;
	public static final String NAME = "SlashBlade Japanese Addons Pack - Rebalanced";
	public static final String VERSION = Tags.VERSION;

	@Instance(SJAP.MOD_ID)
	public static SJAP instance;

	@SidedProxy(clientSide = "cn.mmf.slashblade_addon.ClientProxy", serverSide = "cn.mmf.slashblade_addon.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}
}
