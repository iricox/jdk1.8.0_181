/*
 * Copyright (c) 2011, 2014, Oracle and/or its affiliates. All rights reserved.
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

package javafx.scene.control;

/**
Builder class for javafx.scene.control.TableRow
@see javafx.scene.control.TableRow
@deprecated This class is deprecated and will be removed in the next version
* @since JavaFX 2.0
*/
@javax.annotation.Generated("Generated by javafx.builder.processor.BuilderProcessor")
@Deprecated
public class TableRowBuilder<T, B extends javafx.scene.control.TableRowBuilder<T, B>> extends javafx.scene.control.IndexedCellBuilder<T, B> {
    protected TableRowBuilder() {
    }

    /** Creates a new instance of TableRowBuilder. */
    @SuppressWarnings({"deprecation", "rawtypes", "unchecked"})
    public static <T> javafx.scene.control.TableRowBuilder<T, ?> create() {
        return new javafx.scene.control.TableRowBuilder();
    }

    /**
    Make an instance of {@link javafx.scene.control.TableRow} based on the properties set on this builder.
    */
    public javafx.scene.control.TableRow<T> build() {
        javafx.scene.control.TableRow<T> x = new javafx.scene.control.TableRow<T>();
        applyTo(x);
        return x;
    }
}
