package com.moon.enums;

/**
 * @author benshaoye
 * @date 2018/9/11
 */
public enum PropsEnum {

    sun_cpu_isalist,
    sun_desktop,
    sun_io_unicode_encoding,
    sun_cpu_endian,
    idea_test_cyclic_buffer_size,
    java_vendor_url_bug,
    file_separator,
    java_vendor,
    sun_boot_class_path,
    java_ext_dirs,
    java_version,
    java_vm_info,
    awt_toolkit,
    user_language,
    java_specification_vendor,
    sun_java_command,
    java_home,
    sun_arch_data_model,
    java_vm_specification_version,
    java_class_path,
    user_name,
    file_encoding,
    java_specification_version,
    java_awt_printerjob,
    user_timezone,
    user_home,
    os_version,
    sun_management_compiler,
    java_specification_name,
    java_class_version,
    java_library_path,
    sun_jnu_encoding,
    os_name,
    user_variant,
    java_vm_specification_vendor,
    java_io_tmpdir,
    line_separator,
    visualvm_id,
    java_endorsed_dirs,
    os_arch,
    java_awt_graphicsenv,
    java_runtime_version,
    java_vm_specification_name,
    user_dir,
    user_country,
    user_script,
    sun_java_launcher,
    sun_os_patch_level,
    java_vm_name,
    file_encoding_pkg,
    path_separator,
    java_vm_vendor,
    java_vendor_url,
    sun_boot_library_path,
    java_vm_version,
    java_runtime_name,

    /**
     * 默认路径
     */
    moonBasePath;

    private final String key;
    private final String value;

    PropsEnum() {
        this.value = System.getProperty((this.key = this.name().replace('_', '.')));
    }

    public String key() {
        return key;
    }

    public String value() {
        return value;
    }
}
