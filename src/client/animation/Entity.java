package client.animation;

import client.model.Model;
import client.node.NodeSub;
import client.model.VertexNormal;
// Renamed from Anible to entity.
public class Entity extends NodeSub {
    
    public VertexNormal vertexNormal[];
    public int modelHeight;
    public static boolean aBoolean1427;
    
    public Entity() {
        modelHeight = 1000;
    }
        
    public void method443(int i, int j, int k, int l, int i1, int j1, int k1,
            int l1, int i2) {
        Model class30_sub2_sub4_sub6 = getRotatedModel();
        if (class30_sub2_sub4_sub6 != null) {
            modelHeight = ((Entity) (class30_sub2_sub4_sub6)).modelHeight;
            class30_sub2_sub4_sub6.method443(i, j, k, l, i1, j1, k1, l1, i2);
        }
    }

    public Model getRotatedModel() {
        return null;
    }
}