LOCAL_PATH:= $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE_TAGS := optional

LOCAL_SRC_FILES := $(call find-other-java-files)

LOCAL_MODULE:= androidPlug

ALL_DEFAULT_INSTALLED_MODULES += $(LOCAL_MODULE)

LOCAL_PROGUARD_ENABLED := disabled

LOCAL_MODULE_CLASS := JAVA_LIBRARIES

include $(BUILD_STATIC_JAVA_LIBRARY)
#include $(BUILD_JAVA_LIBRARY)
