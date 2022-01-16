package wide.cat.squake;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class Motions {
    public static double getMotionX(Entity entity) {
        return entity.getVelocity().x;
    }

    public static double getMotionY(Entity entity) {
        return entity.getVelocity().y;
    }

    public static double getMotionZ(Entity entity) {
        return entity.getVelocity().z;
    }

    public static void setMotionX(Entity entity, double motionX) {
        Vec3d motion = entity.getVelocity();
        entity.setVelocity(motionX, motion.y, motion.z);
    }

    public static void setMotionY(Entity entity, double motionY) {
        Vec3d motion = entity.getVelocity();
        entity.setVelocity(motion.x, motionY, motion.z);
    }

    public static void setMotionZ(Entity entity, double motionZ) {
        Vec3d motion = entity.getVelocity();
        entity.setVelocity(motion.x, motion.y, motionZ);
    }

    public static void setMotionHoriz(Entity entity, double motionX, double motionZ) {
        entity.setVelocity(motionX, entity.getVelocity().y, motionZ);
    }

    public static float getSlipperiness(Entity entity, BlockPos pos) {
        return entity.world.getBlockState(pos).getBlock().getSlipperiness();
    }

    public static double getSideMove(Vec3d relative) {
        return relative.x;
    }

    public static double getUpMove(Vec3d relative) {
        return relative.y;
    }

    public static double getForwardMove(Vec3d relative) {
        return relative.z;
    }

    public static boolean notZero(double val) {
        return Math.abs(val) >= 1.0E-4;
    }

    public static boolean isOffsetPositionInLiquid(PlayerEntity player, double x, double y, double z) {
        return player.doesNotCollide(x, y, z) && !player.world.containsFluid(player.getBoundingBox().offset(x, y, z));
    }
}
