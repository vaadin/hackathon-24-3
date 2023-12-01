package org.vaadin.example;

import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.UploadI18N;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;

import static org.vaadin.example.TranslationUtils.*;

public class LocalizedUpload extends Upload implements LocaleChangeObserver {
    @Override
    public void localeChange(LocaleChangeEvent localeChangeEvent) {
        UploadI18N i18n = new UploadI18N();

        i18n.setDropFiles(
                new UploadI18N.DropFiles()
                        .setOne(translate(this, "vaadin.upload.dropFiles.one"))
                        .setMany(translate(this, "vaadin.upload.dropFiles.many")));
        i18n.setAddFiles(
                new UploadI18N.AddFiles()
                        .setOne(translate(this, "vaadin.upload.addFiles.one"))
                        .setMany(translate(this, "vaadin.upload.addFiles.many")));
        i18n.setError(
                new UploadI18N.Error()
                        .setTooManyFiles(translate(this, "vaadin.upload.error.tooManyFiles"))
                        .setFileIsTooBig(translate(this, "vaadin.upload.error.fileIsTooBig"))
                        .setIncorrectFileType(translate(this, "vaadin.upload.error.incorrectFileType")));
        UploadI18N.Uploading uploading = new UploadI18N.Uploading();
        uploading.setStatus(new UploadI18N.Uploading.Status()
                .setConnecting(translate(this, "vaadin.upload.uploading.status.connecting"))
                .setStalled(translate(this, "vaadin.upload.uploading.status.stalled"))
                .setProcessing(translate(this, "vaadin.upload.uploading.status.processing"))
                .setHeld(translate(this, "vaadin.upload.uploading.status.held")));
        uploading.setRemainingTime(new UploadI18N.Uploading.RemainingTime()
                .setPrefix(translate(this, "vaadin.upload.uploading.remainingTime.prefix"))
                .setUnknown(translate(this, "vaadin.upload.uploading.remainingTime.unknown")));
        uploading.setError(new UploadI18N.Uploading.Error()
                .setServerUnavailable(translate(this, "vaadin.upload.uploading.error.serverUnavailable"))
                .setUnexpectedServerError(translate(this, "vaadin.upload.uploading.error.unexpectedServerError"))
                .setForbidden(translate(this, "vaadin.upload.uploading.error.forbidden")));
        i18n.setUploading(uploading);
        i18n.setFile(new UploadI18N.File().setRetry(translate(this, "vaadin.upload.file.retry"))
                .setStart(translate(this, "vaadin.upload.file.start"))
                .setRemove(translate(this, "vaadin.upload.file.remove")));
        i18n.setUnits(translateList(this, "vaadin.upload.units.size"));

        setI18n(i18n);
    }
}
