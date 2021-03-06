/*
 * Copyright (c) 2013, 2014, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package javafx.scene.shape;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.PickRay;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.scene.DirtyBits;
import com.sun.javafx.scene.input.PickResultChooser;
import com.sun.javafx.sg.prism.NGMeshView;
import com.sun.javafx.sg.prism.NGNode;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.WeakChangeListener;

/**
 * The {@code MeshView} class defines a surface with the specified 3D
 * mesh data.
 *
 * @since JavaFX 8.0
 */
public class MeshView extends Shape3D {

    /**
     * Creates a new instance of {@code MeshView} class.
     */
    public MeshView() {
    }

    /**
     * Creates a new instance of {@code MeshView} class with the specified {@code Mesh}
     * surface.
     */
    public MeshView(Mesh mesh) {
        setMesh(mesh);
    }

    /**
     * Specifies the 3D mesh data of this {@code MeshView}.
     *
     * @defaultValue null
     */
    private ObjectProperty<Mesh> mesh;

    public final void setMesh(Mesh value) {
        meshProperty().set(value);
    }

    public final Mesh getMesh() {
        return mesh == null ? null : mesh.get();
    }

    public final ObjectProperty<Mesh> meshProperty() {
        if (mesh == null) {
            mesh = new SimpleObjectProperty<Mesh>(MeshView.this, "mesh") {

                private Mesh old = null;
                private final ChangeListener<Boolean> meshChangeListener =
                        (observable, oldValue, newValue) -> {
                            if (newValue) {
                                impl_markDirty(DirtyBits.MESH_GEOM);
                                impl_geomChanged();
                            }
                        };
                private final WeakChangeListener<Boolean> weakMeshChangeListener =
                        new WeakChangeListener(meshChangeListener);

                @Override
                protected void invalidated() {
                    if (old != null) {
                        old.dirtyProperty().removeListener(weakMeshChangeListener);
                    }
                    Mesh newMesh = get();
                    if (newMesh != null) {
                        newMesh.dirtyProperty().addListener(weakMeshChangeListener);
                    }
                    impl_markDirty(DirtyBits.MESH);
                    impl_markDirty(DirtyBits.MESH_GEOM);
                    impl_geomChanged();
                    old = newMesh;
                }
            };
        }
        return mesh;
    }

    /**
     * @treatAsPrivate implementation detail
     * @deprecated This is an internal API that is not intended for use and will be removed in the next version
     */
    @Deprecated
    @Override public void impl_updatePeer() {
        super.impl_updatePeer();
        NGMeshView peer = impl_getPeer();
        if (impl_isDirty(DirtyBits.MESH_GEOM) && getMesh() != null) {
            getMesh().impl_updatePG();
        }
        if (impl_isDirty(DirtyBits.MESH)) {
            peer.setMesh((getMesh() == null) ? null : getMesh().getPGMesh());
        }
    }

    /**
     * @treatAsPrivate implementation detail
     * @deprecated This is an internal API that is not intended for use and will be removed in the next version
     */
    @Deprecated
    @Override
    protected NGNode impl_createPeer() {
        return new NGMeshView();
    }

    /**
     * @treatAsPrivate implementation detail
     * @deprecated This is an internal API that is not intended for use and will be removed in the next version
     */
    @Deprecated
    @Override
    public BaseBounds impl_computeGeomBounds(BaseBounds bounds, BaseTransform tx) {
        if (getMesh() != null) {
            bounds = getMesh().computeBounds(bounds);
            bounds = tx.transform(bounds, bounds);
        } else {
            bounds.makeEmpty();
        }
        return bounds;
    }

    /**
     * @treatAsPrivate implementation detail
     * @deprecated This is an internal API that is not intended for use and will be removed in the next version
     */
    @Deprecated
    @Override
    protected boolean impl_computeContains(double localX, double localY) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @treatAsPrivate implementation detail
     * @deprecated This is an internal API that is not intended for use and will be removed in the next version
     */
    @Override
    @Deprecated
    protected boolean impl_computeIntersects(PickRay pickRay, PickResultChooser pickResult) {
        return getMesh().impl_computeIntersects(pickRay, pickResult, this, getCullFace(), true);
    }

}
