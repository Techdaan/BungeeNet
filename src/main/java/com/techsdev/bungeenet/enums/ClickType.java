package com.techsdev.bungeenet.enums;

import lombok.Getter;

/**
 * A list of all possible button enums
 *
 * @see <a href="http://wiki.vg/Protocol#Click_Window">http://wiki.vg/Protocol#Click_Window</a>
 */
public enum ClickType {
    LEFT_CLICK(0, 0, false),
    RIGHT_CLICK(0, 1, false),
    SHIFT_LEFT_CLICK(1, 0, false),
    SHIFT_RIGHT_CLICK(1, 1, false),
    KEYBOARD_1(2, 0, false),
    KEYBOARD_2(2, 1, false),
    KEYBOARD_3(2, 2, false),
    KEYBOARD_4(2, 3, false),
    KEYBOARD_5(2, 4, false),
    KEYBOARD_6(2, 5, false),
    KEYBOARD_7(2, 6, false),
    KEYBOARD_8(2, 7, false),
    KEYBOARD_9(2, 8, false),
    MIDDLE_CLICK(3, 2, false),
    DROP_KEY(4, 0, true),
    CTRL_DROP_KEY(4, 1, false),
    LEFT_CLICK_OUTSIDE_WINDOW_EMPTY_HANDED(4, 0, true), //TODO Better name
    RIGHT_CLICK_OUTSIDE_WINDOW_EMPTY_HANDED(4, 1, true), //TODO Better name
    START_LEFT_DRAG(5, 0, true),
    START_RIGHT_DRAG(5, 4, true),
    START_MIDDLE_DRAG(5, 8, true),
    ADD_LEFT_DRAG_SLOT(5, 1, false),
    ADD_RIGHT_DRAG_SLOT(5, 5, false),
    ADD_MIDDLE_DRAG_SLOT(5, 9, false),
    END_LEFT_DRAG(5, 2, true),
    END_RIGHT_DRAG(5, 6, true),
    END_MIDDLE_DRAG(5, 10, true),
    DOUBLE_CLICK(6, 0, false),
    ;

    /**
     * The mode of the click
     */
    @Getter private final byte mode;

    /**
     * The ID of the button clicked
     */
    @Getter private final byte button;

    /**
     * Whether if the click was inside or outside of the screen
     */
    @Getter private final boolean outside;

    ClickType(int mode, int button, boolean outside) {
        this.mode = (byte) mode;
        this.button = (byte) button;
        this.outside = outside;
    }

    /**
     * Retrieves the clicktype from a packet
     * @param mode The mode of the click
     * @param button The button clicked
     * @param slot The slot number which was clicked
     * @return The clicktype that fulfills all the requirements
     */
    public static ClickType of(int mode, int button, short slot) {
        boolean outside = slot == -999;
        for (ClickType clickType : values()) {
            if(clickType.getButton() == (byte) button && clickType.getMode() == (byte) mode && clickType.isOutside() == outside)
                return clickType;
        }

        throw new IllegalArgumentException("No ClickType found for MODE:"+mode+", BUTTON:"+button+", OUTSIDE:"+outside);
    }

}
