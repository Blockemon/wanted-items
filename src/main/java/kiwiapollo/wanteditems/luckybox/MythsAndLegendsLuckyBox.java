package kiwiapollo.wanteditems.luckybox;

import com.github.d0ctorleon.mythsandlegends.MythsAndLegends;
import net.fabricmc.loader.api.FabricLoader;

public class MythsAndLegendsLuckyBox extends LuckyBox implements OptionalItem {
    public MythsAndLegendsLuckyBox() {
        super(new MythsAndLegendsItemFactory());
    }

    @Override
    public boolean test() {
        return FabricLoader.getInstance().isModLoaded(MythsAndLegends.MOD_ID);
    }
}
