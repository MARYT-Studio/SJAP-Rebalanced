package cn.mmf.slashblade_addon;

import cn.mmf.slashblade_addon.entity.EntityLoader;
import cn.mmf.slashblade_addon.item.ItemLoader;
import cn.mmf.slashblade_addon.specialeffect.SELoader;
import mods.flammpfeil.slashblade.SlashBlade;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import thaumcraft.Thaumcraft;
import thaumcraft.api.ThaumcraftApi;


public class CommonProxy {
    private static final SimpleNetworkWrapper network = NetworkRegistry.INSTANCE.newSimpleChannel(SJAP.MOD_ID);
    public static SimpleNetworkWrapper getNetwork() {
        return network;
    }
	public void preInit(FMLPreInitializationEvent event){
		 new ConfigLoader(event);	
		 new SELoader();
		 new ItemLoader(event);
		 new BladeLoader(event);
		 network.registerMessage(new PacketKeyMessageHandler(),PacketKeyMessage.class,0,Side.SERVER);
	}
    public void init(FMLInitializationEvent event)
    { 
    	new EntityLoader();

    	if(Loader.isModLoaded(Thaumcraft.MODID)){
   		 ThaumcraftApi.registerResearchLocation(new ResourceLocation(SlashBlade.modid,"research/research.json"));
    	}
    }

    public void postInit(FMLPostInitializationEvent event)
    {

    }
}
