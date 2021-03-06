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
Builder class for javafx.scene.control.PasswordField
@see javafx.scene.control.PasswordField
@deprecated This class is deprecated and will be removed in the next version
* @since JavaFX 2.0
*/
@javax.annotation.Generated("Generated by javafx.builder.processor.BuilderProcessor")
@Deprecated
public class PasswordFieldBuilder<B extends javafx.scene.control.PasswordFieldBuilder<B>> extends javafx.scene.control.TextFieldBuilder<B> {
    protected PasswordFieldBuilder() {
    }

    /** Creates a new instance of PasswordFieldBuilder. */
    @SuppressWarnings({"deprecation", "rawtypes", "unchecked"})
    public static javafx.scene.control.PasswordFieldBuilder<?> create() {
        return new javafx.scene.control.PasswordFieldBuilder();
    }

    private boolean __set;
    public void applyTo(javafx.scene.control.PasswordField x) {
        super.applyTo(x);
        if (__set) x.setPromptText(this.promptText);
    }

    private java.lang.String promptText;
    /**
    Set the value of the {@link javafx.scene.control.PasswordField#getPromptText() promptText} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B promptText(java.lang.String x) {
        this.promptText = x;
        __set = true;
        return (B) this;
    }

    /**
    Make an instance of {@link javafx.scene.control.PasswordField} based on the properties set on this builder.
    */
    public javafx.scene.control.PasswordField build() {
        javafx.scene.control.PasswordField x = new javafx.scene.control.PasswordField();
        applyTo(x);
        return x;
    }
}
